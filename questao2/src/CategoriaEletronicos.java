public class CategoriaEletronicos implements Categoria {
    @Override public String nome() { return "Eletrônicos"; }
    @Override public RegraComissao regraPadrao() { return new ComissaoEletronicos(); }
}


