package br.com.projetowheels.model;

import lombok.Getter;

public class Bike {
    @Getter
    protected static Bike[] bikeList = new Bike[12];
    protected int deposito = 0;
    protected int avaliacao = 0;
    protected int bikeNumbero = 0;

    public Bike(int dep, int rat, int num) {
        deposito = dep;
        avaliacao = rat;
        bikeNumbero = num;
    }

    static {
        int j = 0;
        for (int i = 10; i < 21; i++) {
            Bike b = new Bike(i, i, (j * 100));
            bikeList[j] = b;
            j++;
        }
    }

    public int getDeposito() {
        return deposito;
    }

    public int getBikeNumbero() {
        return bikeNumbero;
    }

    public static Bike encontrarBike(int bikeNum) {
        int numberOfBikes = bikeList.length;

        for (int i = 0; i < numberOfBikes; i++) {
            if (bikeList[i].getBikeNumbero() == bikeNum) {
                System.out.println("Bike com numero: " + bikeNum + " encontrada");
                return bikeList[i];
            }
        }
        System.out.println("Bike com numero: " + bikeNum + " não encontrada\n");
        return null;
    }

    public String mostrarDetalhes() {
        return "Detalhes da Bike de numero: " + bikeNumbero + "\nDEPOSITO: " + deposito + "\nAVALIAÇÃO: " + avaliacao;
    }

    public String calcularCusto(int numberOfDays) {
        int cost = deposito + (avaliacao * numberOfDays);
        return "Custo do Aluguel: " + cost;
    }
}

