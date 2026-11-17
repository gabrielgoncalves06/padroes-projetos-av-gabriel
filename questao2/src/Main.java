public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Pintura a óleo 1920", new CategoriaArte(), 10000, 15000);
        Lote notebook = new Lote("Notebook gamer", new CategoriaEletronicos(), 3000, 5000);

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();


        for (Lote l : new Lote[]{quadro, notebook}) {
            l.acompanhar(painel);
            l.acompanhar(auditor);
        }

        quadro.acompanhar(ana);
        quadro.acompanhar(bruno);
        quadro.acompanhar(carla);
        notebook.acompanhar(bruno);
        notebook.acompanhar(carla);


        ana.darLance(quadro, 11000);
        bruno.darLance(quadro, 11200);
        bruno.darLance(quadro, 12000);
        quadro.deixarDeAcompanhar(carla);
        ana.darLance(quadro, 16000);

        bruno.darLance(notebook, 3200);
        carla.darLance(notebook, 3300);
        carla.darLance(notebook, 3500);

        System.out.println("\nCampanha: regra de Eletrônicos aplicada ao lote de Arte");
        quadro.trocarRegra(new ComissaoEletronicos());

        quadro.encerrar();
        notebook.encerrar();
        System.out.println("\n\"" + quadro.nome() + "\": " + (quadro.vendido() ? "vendido" : "não vendido"));
        System.out.println("\"" + notebook.nome() + "\": " + (notebook.vendido() ? "vendido" : "não vendido"));
        System.out.println();

        AcertoVendedor.imprimir(quadro);
        System.out.println();

        Fatura fatura = new FaturaBase(quadro.nome(), quadro.valorVenda());
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        ImpressoraFatura.imprimir(fatura);
        System.out.println();

        auditor.imprimirRegistros();

    }


}















