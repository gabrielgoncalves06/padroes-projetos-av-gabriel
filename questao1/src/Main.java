import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Provisionador provisionador = new Provisionador();

        List<Thread> threads = List.of(
                new Thread(() -> provisionador.provisionar(new SolicitacaoAmbiente("web-producao", "Aws", 2, 100))),
                new Thread(() -> provisionador.provisionar(new SolicitacaoAmbiente("analytics", "Aws", 3, 200))),
                new Thread(() -> provisionador.provisionar(new SolicitacaoAmbiente("backoffice", "Azure", 2, 50))));

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        provisionador.provisionar(new SolicitacaoAmbiente("big-data", "Azure", 10, 500));

        System.out.println("=== Histórico de auditoria ===");
        HistoricoAuditoria.getInstance().listar().forEach(System.out::println);

    }
}







