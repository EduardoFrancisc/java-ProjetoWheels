package br.com.projetowheels.model;

public class Pagamento {
    private Cliente cliente = null;
    private int pagamentoId = 0;

    private static int contadorDePagamentos = 001;

    public Pagamento(Cliente custo) {
        cliente = custo;
        pagamentoId = contadorDePagamentos++;
    }

    public String calculateTotalPayment(Contrato contrato) {
        return issueReceipt(contrato);
    }

    private String issueReceipt(Contrato contrato) {
        String cust = contrato.getCustomer().getName();
        String pCode = contrato.getCustomer().getPostcode();

        contrato.getBike().calcularCusto(contrato.getNumeroDeDias());

        return "Emprimindo o recibo para " + cust + "..." + "\nNo codigo postal:  " + pCode + "\nContratanto bike de numero: " + contrato.getBike().getBikeNumbero() + " por " + contrato.getNumeroDeDias() + " dias";
    }
}
