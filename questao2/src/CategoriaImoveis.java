public class CategoriaImoveis implements Categoria {
    @Override public String nome() { return "Imóveis"; }
    @Override public RegraComissao regraPadrao() { return new ComissaoImoveis(); }
}
