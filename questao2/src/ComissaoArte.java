public class ComissaoArte implements RegraComissao {
    @Override public double calcular(double valorVenda) { return valorVenda * 0.20; }
    @Override public String descricao() { return "Arte: 20%"; }
}


