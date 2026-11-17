public class ComissaoVeiculos implements RegraComissao {
    @Override public double calcular(double valorVenda) { return Math.min(valorVenda * 0.08, 5000.00); }
    @Override public String descricao() { return "Veículos: 8% (máx. R$ 5.000,00)"; }
}
