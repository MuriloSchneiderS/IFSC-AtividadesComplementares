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

    public List<AtividadeComplementar> consultarPorModalidade(int idModalidade){
        String sql = "select id, descricao, limite_maximo from atividade_complementar where modalidade_id = " + idModalidade + ";";
        List<AtividadeComplementar> atividades = new ArrayList<>();
        try {
            Statement stm = conexao.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                atividades.add(new AtividadeComplementar(result.getInt("id"), result.getString("descricao"), result.getInt("limite_maximo")));
            }
            return atividades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}