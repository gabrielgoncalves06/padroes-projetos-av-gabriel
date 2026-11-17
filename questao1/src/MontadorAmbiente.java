import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {
    private final FabricaNuvem fabrica;

    public MontadorAmbiente(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public double estimar(SolicitacaoAmbiente s) {
        return fabrica.precos().estimar(s.quantidadeMaquinas(), s.gbArmazenamento());
    }

    public Ambiente montar(SolicitacaoAmbiente s, double custoMensal) {
        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < s.quantidadeMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquina());
        }
        return new Ambiente(s.nome(), fabrica.nome(), Configuracao.getInstance().getRegiaoPadrao(),
                maquinas, fabrica.criarArmazenamento(), fabrica.criarFila(), custoMensal);
    }
}
