public class SeguroTransporte extends ServicoAdicional {
    private final double valorVenda;

    public SeguroTransporte(Fatura fatura) {
        super(fatura);
        this.valorVenda = fatura.valorVenda();
    }


    @Override protected String descricao() { return "Seguro de transporte (1,5%)"; }
    @Override protected double custo() { return valorVenda * 0.015; }


}

