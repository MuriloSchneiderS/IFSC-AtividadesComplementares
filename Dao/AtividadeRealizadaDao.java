package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.AtividadeComplementar;
import Model.AtividadeRealizada;
import Model.Requerimento;

public class AtividadeRealizadaDao {
    Connection conexao;

    public AtividadeRealizadaDao(){
        conexao = ConexaoDao.getConexao();
    }

    public AtividadeRealizada insertAtividadeRealizada(Requerimento requerimento, AtividadeComplementar atividadeComplementar, int horas_apresentadas){
        String sql = "insert into atividade_realizada (requerimento_id, atividade_id, horas_apresentadas, documento) values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, requerimento.id());
            ps.setInt(2, atividadeComplementar.id());
            ps.setInt(3, horas_apresentadas);
            ps.setString(4, "uploads/documento_exemplo.pdf");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            return new AtividadeRealizada(generatedId, 6, atividadeComplementar.id(), horas_apresentadas, "uploads/documento_exemplo.pdf");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<AtividadeRealizada> consultarAtividadesRealizadasPorRequerimento(Requerimento requerimento) {
        String sql = "select * from atividade_realizada where requerimento_id = "+requerimento.id();
        List<AtividadeRealizada> atividadesRealizadas = new ArrayList<>();
        try (PreparedStatement pstmt = ConexaoDao.setComando(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                atividadesRealizadas.add(new AtividadeRealizada(
                    rs.getInt("id"),
                    rs.getInt("requerimento_id"),
                    rs.getInt("atividade_id"),
                    rs.getInt("horas_apresentadas"),
                    rs.getString("documento")
                ));
            }
            return atividadesRealizadas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public AtividadeRealizada consultarPorId(int idAtividadeRealizada) {
        String sql = "select * from atividade_realizada where id = " + idAtividadeRealizada + ";";
        try (PreparedStatement pstmt = ConexaoDao.setComando(sql)) {
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new AtividadeRealizada(
                    rs.getInt("id"),
                    rs.getInt("requerimento_id"),
                    rs.getInt("atividade_id"),
                    rs.getInt("horas_apresentadas"),
                    rs.getString("documento")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
