
public class Provisionador {

    public void provisionar(SolicitacaoAmbiente s) {
        FabricaNuvem fabrica = SeletorProvedor.obter(s.provedor());
        MontadorAmbiente montador = new MontadorAmbiente(fabrica);
        double custo = montador.estimar(s);
        double orcamento = Configuracao.getInstance().getOrcamentoMensalMaximo();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstance();

        if (custo > orcamento) {
            String motivo = "custo estimado " + Dinheiro.formatar(custo)
                    + " acima do orçamento de " + Dinheiro.formatar(orcamento);
            historico.registrar(s.nome(), fabrica.nome(), "RECUSADO: " + motivo);
            System.out.println("Ambiente " + s.nome() + " recusado: " + motivo + "\n");
            return;
        }

        Ambiente ambiente = montador.montar(s, custo);
        System.out.println(ambiente.resumo());
        historico.registrar(s.nome(), fabrica.nome(), "ACEITO");
    }
}







