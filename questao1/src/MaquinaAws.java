public class MaquinaAws implements MaquinaVirtual {
    public static final double CUSTO_HORA = 0.10;
    private final String id;

    public MaquinaAws(int numero) {
        this.id = "i-" + numero;
    }

    @Override public String getId() { return id; }
    @Override public double custoPorHora() { return CUSTO_HORA; }
}





