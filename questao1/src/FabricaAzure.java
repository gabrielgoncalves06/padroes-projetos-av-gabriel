import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure implements FabricaNuvem {
    private final AtomicInteger maquinas = new AtomicInteger();
    private final AtomicInteger armazenamentos = new AtomicInteger();
    private final AtomicInteger filas = new AtomicInteger();

    @Override public String nome() { return "Azure"; }

    @Override
    public Precos precos() {
        return new Precos(MaquinaAzure.CUSTO_HORA, ArmazenamentoAzure.CUSTO_GB, FilaAzure.CUSTO_FIXO);
    }

    @Override public MaquinaVirtual criarMaquina() { return new MaquinaAzure(maquinas.incrementAndGet()); }
    @Override public Armazenamento criarArmazenamento() { return new ArmazenamentoAzure(armazenamentos.incrementAndGet()); }
    @Override public Fila criarFila() { return new FilaAzure(filas.incrementAndGet()); }
}
