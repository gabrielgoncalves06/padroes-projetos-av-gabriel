import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public final class Configuracao {
    private final String regiaoPadrao;
    private final double orcamentoMensalMaximo;


    private Configuracao() {
        Properties p = new Properties();
        try (FileInputStream in = new FileInputStream("config.properties")) {
            p.load(in);
        } catch (IOException e) {
            throw new IllegalStateException("Não foi possível ler config.properties", e);
        }
        this.regiaoPadrao = p.getProperty("regiao.padrao");
        this.orcamentoMensalMaximo = Double.parseDouble(p.getProperty("orcamento.mensal.maximo"));
    }

    private static class Holder {
        static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstance() {
        return Holder.INSTANCIA;
    }

    public String getRegiaoPadrao() { return regiaoPadrao; }
    public double getOrcamentoMensalMaximo() { return orcamentoMensalMaximo; }


}






















