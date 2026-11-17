public class Participante implements Licitante, Observador {
    private final String nome;

    public Participante(String nome) { this.nome = nome; }

    @Override public String nome() { return nome; }

    public void darLance(Lote lote, double valor) {
        ResultadoLance r = lote.darLance(this, valor);
        System.out.println(nome + " dá lance de " + Dinheiro.formatar(valor) + " em \"" + lote.nome() + "\": "
                + (r.aceito() ? "ACEITO" : "RECUSADO - " + r.mensagem()));
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("   [" + nome + "] Novo lance em \"" + lote.nome() + "\": " + Dinheiro.formatar(lance.valor()));
    }
}
