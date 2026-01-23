package repository;

import model.Arquiteto;
import model.Cliente;
import model.Projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    public static void salvar(Projeto projeto){
        String sql = "INSERT INTO projetos (nome_projeto, endereco_projeto, fase_projeto, arquiteto_id, cliente_id) " +
                "VALUES (?,?,?,?,?)";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getEnderecoProjeto());
            stmt.setString(3, projeto.getFaseDoProjeto());
            stmt.setInt(4, projeto.getArquitetoResponsavel().getId());
            stmt.setInt(5, projeto.getCliente().getId());

            stmt.executeUpdate();

            System.out.println("Projeto adicionado com Sucesso!!");
        }catch(SQLException e){
            System.err.println("Erro ao adicionar projeto: " + e.getMessage());
        }
    }

    public static List<Projeto> listarTodos(){
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM projetos";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArquitetoDAO arqDAO = new ArquitetoDAO();
            ClienteDAO cliDAO = new ClienteDAO();

            while (rs.next()){
                int idProjeto = rs.getInt("id");
                String nome = rs.getString("nome_projeto");
                String endereco = rs.getString("endereco_projeto");
                String faseDoProjeto = rs.getString("fase_projeto");
                int idArquiteto = rs.getInt("arquiteto_id");
                int idCliente = rs.getInt("cliente_id");

                Arquiteto arquiteto = arqDAO.buscarPorId(idArquiteto);
                Cliente cliente = cliDAO.buscarPorId(idCliente);
                Projeto p = new Projeto(idProjeto, nome,endereco,faseDoProjeto,arquiteto,cliente);

                projetos.add(p);
            }
        }catch (SQLException e){
            System.err.println("Erro ao listar: " + e.getMessage());
        }
        return projetos;
    }
}
