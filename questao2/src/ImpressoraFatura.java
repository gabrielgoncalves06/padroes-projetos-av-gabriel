public final class ImpressoraFatura {
    private ImpressoraFatura() {}

    public static void imprimir(Fatura fatura) {
        System.out.println("=== Fatura do comprador ===");
        System.out.println(fatura.detalhar());
        System.out.println("Total a pagar: " + Dinheiro.formatar(fatura.total()));
    }
}
