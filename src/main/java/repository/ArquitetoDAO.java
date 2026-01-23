package repository;

import model.Arquiteto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            Conexao.fecharConexao(conn);
            System.out.println("Encerrando Conexão com o Banco");
        }catch(SQLException e){
            System.err.println("Erro ao salvar arquiteto: " + e.getMessage());
        }
    }

    public static Arquiteto buscarPorCpf(String cpf){
        String sql = "SELECT * FROM arquitetos WHERE cpf = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cpf);

            //Usando o Result Set para passar para o sistema os dados Retornados do Select no SQL
            try{
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    //Criação de um Arquiteto com ID
                    return new Arquiteto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("cau")
                    );
                }
            }catch (SQLException e){
                System.err.println("Erro ao buscar arquiteto: " + e.getMessage());
            }
        }catch (SQLException e){
            System.err.println("Erro ao buscar arquiteto: " + e.getMessage());
        }
        return null;
    }

    public Arquiteto buscarPorId(int id){
        String sql = "SELECT * FROM arquitetos WHERE id = ?";
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            try{
                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    return new Arquiteto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("cau")
                    );
                }
            }catch (SQLException e){
                System.err.println("Erro ao buscar ID: " + e.getMessage());
            }
        }catch (SQLException e){
            System.err.println("Erro ao buscar ID: " + e.getMessage());
        }
        return null;
    }
}
