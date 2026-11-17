public class MaquinaAzure implements MaquinaVirtual {
    public static final double CUSTO_HORA = 0.12;
    private final String id;

    public MaquinaAzure(int numero) {
        this.id = "vm-" + numero;
    }

    @Override public String getId() { return id; }
    @Override public double custoPorHora() { return CUSTO_HORA; }
}







