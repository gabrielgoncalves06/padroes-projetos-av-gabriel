public class FilaAzure implements Fila {
    public static final double CUSTO_FIXO = 0.50;
    private final String id;

    public FilaAzure(int numero) {
        this.id = "sb-" + numero;
    }

    @Override public String getId() { return id; }
    @Override public double custoFixo() { return CUSTO_FIXO; }

}



