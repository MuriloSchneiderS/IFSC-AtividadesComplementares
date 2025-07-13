package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.AtividadeComplementar;


public class AtividadeComplementarDao {
    
    Connection conexao;

    public AtividadeComplementarDao(){
        conexao = ConexaoDao.getConexao();
    }

    public List<AtividadeComplementar> consultarPorModalidade(int idModalidade){
        String sql = "select * from atividade_complementar where modalidade_id = " + idModalidade + ";";
        List<AtividadeComplementar> atividades = new ArrayList<>();
        try (PreparedStatement pstmt = ConexaoDao.setComando(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                atividades.add(new AtividadeComplementar(
                    rs.getInt("id"),
                    rs.getString("descricao"),
                    rs.getInt("limite_maximo")
                ));
            }
            return atividades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}