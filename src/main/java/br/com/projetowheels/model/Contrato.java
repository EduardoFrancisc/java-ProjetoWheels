package br.com.projetowheels.model;

import java.util.Date;

public class Contrato {
    private Date dataContratacao = null;
    private Cliente cliente = null;
    private Bike bike = null;
    private int numeroDeDias = 0;
    private int contratoId = 0;
    private static int contadorContrato = 001;

    public Contrato(Date sDate, int numDays, Bike bikeToHire, Cliente custo) {
        this.dataContratacao = sDate;
        this.cliente = custo;
        this.bike = bikeToHire;
        this.numeroDeDias = numDays;
        this.contratoId = contadorContrato++;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public Cliente getCustomer() {
        return cliente;
    }

    public Bike getBike() {
        return bike;
    }

    public int getNumeroDeDias() {
        return numeroDeDias;
    }

    public int getHired() {
        return contratoId;
    }

    public static int getContadorContrato() {
        return contadorContrato;
    }
}
