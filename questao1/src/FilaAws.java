public class FilaAws implements Fila {
    public static final double CUSTO_FIXO = 0.40;
    private final String id;

    public FilaAws(int numero) {
        this.id = "sqs-" + numero;
    }

    @Override public String getId() { return id; }
    @Override public double custoFixo() { return CUSTO_FIXO; }

    
}






