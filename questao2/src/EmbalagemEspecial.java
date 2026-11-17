public class EmbalagemEspecial extends ServicoAdicional {
    public EmbalagemEspecial(Fatura fatura) { super(fatura); }

    @Override protected String descricao() { return "Embalagem especial"; }
    @Override protected double custo() { return 180.00; }
}
