public class ArmazenamentoAzure implements Armazenamento {
    public static final double CUSTO_GB = 0.02;
    private final String id;

    public ArmazenamentoAzure(int numero) {
        this.id = "blob://" + numero;
    }

    @Override public String getId() { return id; }
    @Override public double custoPorGb() { return CUSTO_GB; }
}






