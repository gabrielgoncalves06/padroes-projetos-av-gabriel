public class FaturaBase implements Fatura {
    private final String lote;
    private final double valorVenda;

    public FaturaBase(String lote, double valorVenda) {
        this.lote = lote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String detalhar() {
        return "Lote: " + lote + "\nValor de venda: " + Dinheiro.formatar(valorVenda);
    }

    @Override public double valorVenda() { return valorVenda; }
    @Override public double total() { return valorVenda; }
}



