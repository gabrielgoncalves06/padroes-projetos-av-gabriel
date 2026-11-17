public class ComissaoImoveis implements RegraComissao {
    @Override public double calcular(double valorVenda) { return valorVenda * 0.03 + 1500.00; }
    @Override public String descricao() { return "Imóveis: 3% + R$ 1.500,00"; }
}


