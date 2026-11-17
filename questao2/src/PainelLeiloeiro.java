public class PainelLeiloeiro implements Observador {
    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("   [Painel]   \"" + lote.nome() + "\" | maior lance: " + Dinheiro.formatar(lote.lanceAtual())
                + " | total de lances: " + lote.totalLances());
          
    }


}



