package br.com.projetowheels.model;

public class Cliente {
    private String nome;
    private String codigoPostal;
    private long telefone;
    private int clienteId;

    private static int totalDeClientes = 001;

    public Cliente(String name, String codigoPostal, long telefone) {
        this.nome = name;
        this.codigoPostal = codigoPostal;
        this.telefone = telefone;
        this.clienteId = clienteId++;
    }

    public int getCustomerNumber() {
        return clienteId;
    }

    public String getName() {
        return nome;
    }

    public String getPostcode() {
        return codigoPostal;
    }
}
