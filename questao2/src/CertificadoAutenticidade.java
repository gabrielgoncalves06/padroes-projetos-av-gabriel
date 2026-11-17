public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade(Fatura fatura) { super(fatura); }

    @Override protected String descricao() { return "Certificado de autenticidade"; }
    @Override protected double custo() { return 300.00; }
}
