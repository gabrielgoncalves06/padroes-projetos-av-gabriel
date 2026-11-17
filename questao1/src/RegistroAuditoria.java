import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record RegistroAuditoria(LocalDateTime dataHora, String ambiente, String provedor, String resultado) {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    @Override
    public String toString() {
        return dataHora.format(FMT) + " | " + ambiente + " | " + provedor + " | " + resultado;
    }
}



