import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Lote {
    private final String nome;
    private final Categoria categoria;
    private final double precoInicial;
    private final double precoReserva;
    private final List<Observador> observadores = new CopyOnWriteArrayList<>();
    private final List<Lance> lances = new ArrayList<>();
    private RegraComissao regra;
    private boolean aberto = true;
    private boolean vendido;
    private double comissao;

    public Lote(String nome, Categoria categoria, double precoInicial, double precoReserva) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.regra = categoria.regraPadrao();

    }

    public void acompanhar(Observador o) { observadores.add(o); }

    public void deixarDeAcompanhar(Observador o) { observadores.remove(o); }

    public ResultadoLance darLance(Licitante autor, double valor) {
        if (!aberto) {
            return new ResultadoLance(false, "lote encerrado");
        }

        double minimo = lanceAtual() * 1.05;
        if (valor + 1e-9 < minimo) {
            return new ResultadoLance(false, "o lance deve ser de pelo menos " + Dinheiro.formatar(minimo)
                    + " (5% acima do lance atual de " + Dinheiro.formatar(lanceAtual()) + ")");
        }

        Lance lance = new Lance(autor, valor, LocalDateTime.now());
        lances.add(lance);
        for (Observador o : observadores) {
            if (o != autor) {
                o.atualizar(this, lance);
            }
        }

        return new ResultadoLance(true, "lance aceito");
    }

    public void trocarRegra(RegraComissao nova) {
        if (!aberto) {
             throw new IllegalStateException("Lote encerrado: a regra de comissão não pode mais ser trocada");
        }

        this.regra = nova;
    }

    
    public void encerrar() {
        if (!aberto) return;
        aberto = false;
        if (!lances.isEmpty() && lanceAtual() >= precoReserva) {
            vendido = true;
            comissao = regra.calcular(lanceAtual());
        }

    }

    public String nome() { return nome; }
    public Categoria categoria() { return categoria; }
    public RegraComissao regra() { return regra; }
    public boolean aberto() { return aberto; }
    public boolean vendido() { return vendido; }
    public int totalLances() { return lances.size(); }
    public double comissao() { return comissao; }

    public double lanceAtual() {
        return lances.isEmpty() ? precoInicial : lances.get(lances.size() - 1).valor();
    }


    public double valorVenda() { return vendido ? lanceAtual() : 0; }

    public Licitante comprador() {
        return vendido ? lances.get(lances.size() - 1).autor() : null;
    }

}







