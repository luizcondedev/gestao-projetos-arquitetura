package repository;

import model.Arquiteto;
import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void salvar(Cliente cliente){
        String insertSQL = "INSERT INTO clientes(nome, email, cpf, telefone_contato) VALUES (?,?,?,?);";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(insertSQL);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getTelefoneContato());

            stmt.executeUpdate();

            System.out.println("Cliente salvo com sucesso!");
            Conexao.fecharConexao(conn);
            System.out.println("Encerrando Conexão com o Banco");
        }catch (SQLException e){
            System.err.println("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarPorCpf(String cpf){
        String sql = "SELECT * FROM clientes WHERE cpf = ?";

        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cpf);
            try{
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    //Criação de um Arquiteto com ID
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("telefone_contato")
                    );
                }
            }catch (SQLException e){
                System.err.println("Erro ao buscar Cliente: " + e.getMessage());
            }
        }catch (SQLException e){
            System.err.println("Erro ao buscar Cliente: " + e.getMessage());
        }
        return null;
    }

    public Cliente buscarPorId(int id){
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            try{
                ResultSet rs = stmt.executeQuery();

                if(rs.next()){
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("cpf"),
                            rs.getString("telefone_contato")
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
