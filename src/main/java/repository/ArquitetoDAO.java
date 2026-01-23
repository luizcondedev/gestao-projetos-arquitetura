package repository;

import model.Arquiteto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArquitetoDAO {

    public static void salvar(Arquiteto arquiteto){
        String insertSQL = "INSERT INTO arquitetos(nome, email, cpf, cau) VALUES (?,?,?,?)";

        try{
            //Abrindo Conexao com o Banco de dados
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            //Preenchendo as lacunas "?" com o PreparedStatement
            stmt.setString(1, arquiteto.getNome());
            stmt.setString(2, arquiteto.getEmail());
            stmt.setString(3, arquiteto.getCpf());
            stmt.setString(4, arquiteto.getCAU());

            //Executando a query SQL
            stmt.executeUpdate();

            System.out.println("Arquiteto salvo com sucesso!");
        }catch(SQLException e){
            System.err.println("Erro ao salvar arquiteto: " + e.getMessage());
        }


    }
}
