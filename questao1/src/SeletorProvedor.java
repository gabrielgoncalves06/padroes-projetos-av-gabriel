import java.util.Map;

public final class SeletorProvedor {
    private static final Map<String, FabricaNuvem> FABRICAS = Map.of(
            "aws", new FabricaAws(),
            "azure", new FabricaAzure());

    private SeletorProvedor() {}

    public static FabricaNuvem obter(String provedor) {
        FabricaNuvem fabrica = FABRICAS.get(provedor.toLowerCase());
        if (fabrica == null) {
            throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
        return fabrica;
    }
}


