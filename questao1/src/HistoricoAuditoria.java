import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public final class HistoricoAuditoria {
    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();
    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private HistoricoAuditoria() {}

    public static HistoricoAuditoria getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(new RegistroAuditoria(LocalDateTime.now(), ambiente, provedor, resultado));
    }

    public synchronized List<RegistroAuditoria> listar() {
        return List.copyOf(registros);
    }
}




