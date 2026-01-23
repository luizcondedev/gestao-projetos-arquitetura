package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //Atributos com os dados do Banco
    private static final String url = "jdbc:postgresql://localhost:5432/db_projetos_arq";
    private static final String usuario = "postgres";
    private static final String senha = "1234";

    //Metodo para abrir a conexão

    public static Connection conectar(){
        try{
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.err.println("Erro ao conectao ao banco" + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conn){
        try{
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }



}
