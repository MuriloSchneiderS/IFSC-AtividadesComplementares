package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Aluno;
import Model.Requerimento;

public class RequerimentoDao {
    Connection conexao;

    public RequerimentoDao(){
        conexao = ConexaoDao.getConexao();
    }

    public Requerimento insertRequerimento(Aluno aluno) {
        String sql = "insert into requerimento values (default," + aluno.id() + ", default, default, null);";
        try {
            conexao.createStatement().executeUpdate(sql);
            return ultimoRequerimentoDoAluno(aluno.id());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Requerimento ultimoRequerimentoDoAluno(int alunoId) {
        String sql = "SELECT * FROM requerimento WHERE aluno_id = " + alunoId + " ORDER BY id DESC LIMIT 1";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            if (rs.next()) {
                return new Requerimento(
                    rs.getInt("id"),
                    rs.getInt("aluno_id"),
                    rs.getString("data_requerimento"),
                    rs.getString("status"),
                    rs.getString("data_validacao")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Requerimento penultimoRequerimentoDoAluno(int alunoId) {
        String sql = "SELECT * FROM requerimento WHERE aluno_id = " + alunoId + " ORDER BY id DESC LIMIT 1 OFFSET 1";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            if (rs.next()) {
                return new Requerimento(
                    rs.getInt("id"),
                    rs.getInt("aluno_id"),
                    rs.getString("data_requerimento"),
                    rs.getString("status"),
                    rs.getString("data_validacao")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
