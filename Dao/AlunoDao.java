package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Aluno;

public class AlunoDao {
    Connection conexao;

    public AlunoDao(){
        conexao = ConexaoDao.getConexao();
    }
    
    public void salvar(Aluno aluno){
        try {
            Statement stm = conexao.createStatement();
            String sql = "insert into aluno (nome, matricula) values ('"+aluno.nome()+"', '"+aluno.matricula()+"');";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}