package app;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;
import repository.ArquitetoDAO;
import repository.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Arquiteto luiz = new Arquiteto("Luiz", "luizconde.arq@gmail.com", "15528296773", "00183232");
        Cliente julia = new Cliente("Julia", "julialaa@gmail.com", "1212121212", "2197728282");

        ArquitetoDAO.salvar(luiz);

    }
}
