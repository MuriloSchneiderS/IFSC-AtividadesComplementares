package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.AtividadeComplementar;
import Model.AtividadeRealizada;
import Model.Parecer;
import Model.ValidacaoAtividade;

public class ValidacaoAtividadeDao {
    Connection conexao;

    public ValidacaoAtividadeDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void insertValidacaoAtividade(AtividadeRealizada atividade_realizada, AtividadeComplementar atividade_complementar, Parecer parecer, int horas_apresentadas) {
        // Valida as horas apresentadas de acordo com o limite da atividade complementar
        // Insere as horas validadas na tabela validacao_atividade
        String sql = "insert into validacao_atividade values (default, "+atividade_realizada.id()+", "+validarHoras(horas_apresentadas, atividade_complementar.limite_horas())+", "+parecer.id()+")";
        try {
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ValidacaoAtividade consultarValidacaoPorAtividadeRealizada(AtividadeRealizada atividadeRealizada) {
        String sql = "select * from validacao_atividade where atividade_realizada_id = " + atividadeRealizada.id() + ";";
        try (PreparedStatement pstmt = ConexaoDao.setComando(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new ValidacaoAtividade(
                    rs.getInt("id"),
                    rs.getInt("atividade_realizada_id"),
                    rs.getInt("horas_validadas"),
                    rs.getInt("parecer_id")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validarHoras(int horas_apresentadas, int limite_horas){
        if (horas_apresentadas > limite_horas) 
            return limite_horas;
        else if(horas_apresentadas < 0) 
            return 0; 
        else 
            return horas_apresentadas;
        
    }
}
