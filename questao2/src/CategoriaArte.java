public class CategoriaArte implements Categoria {
    @Override public String nome() { return "Arte"; }
    @Override public RegraComissao regraPadrao() { return new ComissaoArte(); }
}



