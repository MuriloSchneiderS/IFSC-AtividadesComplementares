package Dao;

import java.sql.Connection;
import java.sql.ResultSet;

import Model.Parecer;
import Model.Requerimento;

public class ParecerDao {
    Connection conexao;

    public ParecerDao(){
        conexao = ConexaoDao.getConexao();
    }

    public Parecer insertParecer(Requerimento requerimento){
        String sql = "insert into parecer values (default, "+requerimento.id()+", 'Atividades validadas conforme regulamento, documentação consistente.', default)";
        try {
            conexao.createStatement().executeUpdate(sql);
            return ultimoParecerDoRequerimento(requerimento);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Parecer ultimoParecerDoRequerimento(Requerimento requerimento) {
        String sql = "SELECT * FROM parecer WHERE requerimento_id = " + requerimento.id() + " ORDER BY id DESC LIMIT 1";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            if (rs.next()) {
                return new Parecer(
                    rs.getInt("id"),
                    rs.getInt("requerimento_id"),
                    rs.getString("texto"),
                    rs.getString("data_parecer")
                );
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
