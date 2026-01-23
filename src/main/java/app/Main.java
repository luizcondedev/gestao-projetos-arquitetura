package app;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;
import repository.ArquitetoDAO;
import repository.ClienteDAO;
import repository.Conexao;
import repository.ProjetoDAO;

import java.sql.Connection;
import java.util.List;

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

        Projeto casaDePraia = new Projeto("Casa de Praia buzios", "Rua do Anjos, Buzios - RJ",
                "Estudo Preliminar", luizComId, juliaComId);
        Projeto reformaApartamento = new Projeto("Reforma Apartamento",
                "Rua da usina, 590, Bangu - RJ",
                "Anteprojeto", luizComId, carlosComId);

//        ArquitetoDAO.salvar(luiz);
//        ClienteDAO.salvar(julia);
//        ClienteDAO.salvar(carlos);
//        ProjetoDAO.salvar(casaDePraia);
//        ProjetoDAO.salvar(reformaApartamento);

        List<Projeto> projetos = ProjetoDAO.listarTodos();
        System.out.println("==== LISTA DO PROJETOS ====");
        for(Projeto p : projetos){
            System.out.println(p);
        }

    }
}
