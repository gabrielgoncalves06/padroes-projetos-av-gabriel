public record Precos(double maquinaPorHora, double gbPorMes, double filaFixo) {
    private static final int HORAS_MES = 730;

    public double estimar(int maquinas, int gb) {
        return maquinas * maquinaPorHora * HORAS_MES + gb * gbPorMes + filaFixo;
    }
}




