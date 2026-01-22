package app;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;

public class Main {
    public static void main(String[] args) {
        Arquiteto luiz = new Arquiteto("Luiz", "luizconde.arq@gmail.com", "15528296773", "00183232");
        Cliente julia = new Cliente("Julia", "julialaa@gmail.com", "1212121212", "2197728282");

        Projeto casaDePraia = new Projeto("Casa de Praia Buzios", "Rua dos Anjos, 92 - RJ",
                "Estudo preliminar", luiz, julia);

        System.out.println("O projeto " + casaDePraia.getNomeProjeto() + " será realizado para o cliente " +
                casaDePraia.getCliente().getNome() + " e está na fase de " + casaDePraia.getFaseDoProjeto() +
                " e está sob supervisão do arquiteto " + casaDePraia.getArquitetoResponsavel().getNome() +
                " com o CAU n: " + casaDePraia.getArquitetoResponsavel().getCAU());
    }
}
