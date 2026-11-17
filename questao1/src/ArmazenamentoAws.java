public class ArmazenamentoAws implements Armazenamento {
    public static final double CUSTO_GB = 0.023;
    private final String id;

    public ArmazenamentoAws(int numero) {
        this.id = "s3://" + numero;
        
    }

    @Override public String getId() { return id; }
    @Override public double custoPorGb() { return CUSTO_GB; }
}









