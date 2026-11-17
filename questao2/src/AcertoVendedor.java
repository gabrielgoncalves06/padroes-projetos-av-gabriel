public final class AcertoVendedor {
    private AcertoVendedor() {}

    public static void imprimir(Lote lote) {
        System.out.println("=== Acerto do vendedor: " + lote.nome() + " ===");
        System.out.println("Valor de venda: " + Dinheiro.formatar(lote.valorVenda()));
        System.out.println("Comissão (" + lote.regra().descricao() + "): " + Dinheiro.formatar(lote.comissao()));
        System.out.println("Líquido a repassar: " + Dinheiro.formatar(lote.valorVenda() - lote.comissao()));
    }

}



