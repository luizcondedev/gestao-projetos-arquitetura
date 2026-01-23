package app;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;
import repository.ArquitetoDAO;
import repository.ClienteDAO;
import repository.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Arquiteto luiz = new Arquiteto("Luiz", "luizconde.arq@gmail.com", "15528296773",
                "00183232");
        Cliente julia = new Cliente("Julia", "julialaa@gmail.com", "1212121212",
                "2197728282");

        Cliente carlos = new Cliente("Carlos", "carloslaaa12@gmail.com", "17288239928",
                "219764282");

        Arquiteto luizComId = ArquitetoDAO.buscarPorCpf(luiz.getCpf());
        Cliente juliaComId = ClienteDAO.buscarPorCpf(julia.getCpf());
        Cliente carlosComId = ClienteDAO.buscarPorCpf(carlos.getCpf());

        System.out.println("O ID do Arquiteto " + luizComId.getNome() + " é: " + luizComId.getId());
        System.out.println("O ID do Cliente " + juliaComId.getNome() + " é: " + juliaComId.getId());
        System.out.println("O ID do Cliente " + carlosComId.getNome() + " é: " + carlosComId.getId());

//        ArquitetoDAO.salvar(luiz);
//        ClienteDAO.salvar(julia);
//        ClienteDAO.salvar(carlos);

    }
}
