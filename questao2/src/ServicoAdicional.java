public abstract class ServicoAdicional implements Fatura {
    private final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) { this.fatura = fatura; }

    protected abstract String descricao();
    protected abstract double custo();

    @Override
    public String detalhar() {
        return fatura.detalhar() + "\n  + " + descricao() + ": " + Dinheiro.formatar(custo());
    }

    @Override public double valorVenda() { return fatura.valorVenda(); }
    @Override public double total() { return fatura.total() + custo(); }

}






