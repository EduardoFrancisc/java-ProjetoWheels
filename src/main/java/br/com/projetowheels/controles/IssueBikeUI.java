package br.com.projetowheels.controles;

import br.com.projetowheels.model.Bike;
import br.com.projetowheels.model.Cliente;
import br.com.projetowheels.model.Contrato;
import br.com.projetowheels.model.Pagamento;

import java.util.Date;

public class IssueBikeUI {
    private Bike bikeEscolhida = null;
    private Cliente cliente = null;
    private Pagamento pagamento = null;
    private Contrato contrato = null;
    private int numeroDeDias;

    public String calcularCusto(int numDays) {
        numeroDeDias = numDays;
        return bikeEscolhida.calcularCusto(numDays);
    }

    public void criarCliente(String nome, String codigoPostal, long telefone) {
        cliente = new Cliente(nome, codigoPostal, telefone);
        pagamento = new Pagamento(cliente);
        contrato = new Contrato(new Date(), numeroDeDias, bikeEscolhida, cliente);
    }

    public String calcularPagamentoTotal() {
        return pagamento.calculateTotalPayment(contrato);
    }


    public String mostrarDetalhesDaBicicleta(int bikeId) {
        bikeEscolhida = Bike.encontrarBike(bikeId);
        if (bikeEscolhida != null) {
            return bikeEscolhida.mostrarDetalhes();
        }
        return "error";
    }

}