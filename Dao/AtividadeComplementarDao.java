package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.AtividadeComplementar;


public class AtividadeComplementarDao {
    
    Connection conexao;

    public AtividadeComplementarDao(){
        conexao = ConexaoDao.getConexao();
    }
    
    public List<AtividadeComplementar> consultarTudo(){
        String sql = "select id, nome from atividade_complementar";
        List<AtividadeComplementar> atividade = new ArrayList<>();
        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                atividade.add(new AtividadeComplementar(result.getInt("id"), result.getString("descricao")));
            }
            return atividade;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}