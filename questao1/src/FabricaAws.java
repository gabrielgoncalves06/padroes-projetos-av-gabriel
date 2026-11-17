import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAws implements FabricaNuvem {
    private final AtomicInteger maquinas = new AtomicInteger();
    private final AtomicInteger armazenamentos = new AtomicInteger();
    private final AtomicInteger filas = new AtomicInteger();

    @Override public String nome() { return "Aws"; }

    @Override
    public Precos precos() {
        return new Precos(MaquinaAws.CUSTO_HORA, ArmazenamentoAws.CUSTO_GB, FilaAws.CUSTO_FIXO);
    }

    @Override public MaquinaVirtual criarMaquina() { return new MaquinaAws(maquinas.incrementAndGet()); }
    @Override public Armazenamento criarArmazenamento() { return new ArmazenamentoAws(armazenamentos.incrementAndGet()); }
    @Override public Fila criarFila() { return new FilaAws(filas.incrementAndGet()); }
    
}




