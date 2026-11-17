import java.util.List;
import java.util.stream.Collectors;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final Fila fila;
    private final double custoMensal;


    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, Fila fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }


    public String resumo() {
        String ids = maquinas.stream().map(Recurso::getId).collect(Collectors.joining(", "));
        return "Ambiente: " + nome + "\n"
                + "Provedor: " + provedor + "\n"
                + "Região: " + regiao + "\n"
                + "Máquinas virtuais: " + ids + "\n"
                + "Armazenamento: " + armazenamento.getId() + "\n"
                + "Fila: " + fila.getId() + "\n"
                + "Custo mensal estimado: " + Dinheiro.formatar(custoMensal) + "\n";


    }
}






