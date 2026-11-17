import java.util.Locale;

public final class Dinheiro {
    private static final Locale BR = Locale.forLanguageTag("pt-BR");

    private Dinheiro() {}

    public static String formatar(double valor) {
        return String.format(BR, "R$ %,.2f", valor);
    }
    
}


