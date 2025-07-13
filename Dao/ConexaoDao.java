package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDao{
    private static Connection conexao;
    private static PreparedStatement comando;
    
    public static Connection getConexao(){
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AtividadesComplementares",
            "postgres", "admin");
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static PreparedStatement setComando(String sql){
        try {
            comando = getConexao().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comando;
    }
}