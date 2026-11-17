public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa(Fatura fatura) { super(fatura); }

    @Override protected String descricao() { return "Entrega expressa"; }
    @Override protected double custo() { return 450.00; }
}


