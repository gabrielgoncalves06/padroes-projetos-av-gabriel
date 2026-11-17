import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Observador {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        registros.add(lance.dataHora().format(FMT) + " | " + lote.nome() + " | " + lance.autor().nome()
                + " | " + Dinheiro.formatar(lance.valor()));
    }

    public void imprimirRegistros() {
        System.out.println("=== Registro do auditor ===");
        registros.forEach(System.out::println);
    }
}




