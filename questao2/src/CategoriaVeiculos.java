public class CategoriaVeiculos implements Categoria {
    @Override public String nome() { return "Veículos"; }
    @Override public RegraComissao regraPadrao() { return new ComissaoVeiculos(); }
}


