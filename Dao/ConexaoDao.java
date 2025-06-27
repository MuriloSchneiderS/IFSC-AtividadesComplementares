package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    
    public static Connection getConexao(){
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AtividadesComplementares",
            "postgres", "admin");
            return conexao;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    } 
}