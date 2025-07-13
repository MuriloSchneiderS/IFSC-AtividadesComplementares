package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Modalidade;

public class ModalidadeDao {
    Connection conexao;

    public ModalidadeDao(){
        conexao = ConexaoDao.getConexao();
    }

    public List<Modalidade> consultarModalidades() {
        String sql = "select * from modalidade;";
        List<Modalidade> modalidades = new ArrayList<>();
        try (PreparedStatement pstmt = ConexaoDao.setComando(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                modalidades.add(new Modalidade(
                    rs.getInt("id"),
                    rs.getString("nome")
                ));
            }
            return modalidades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
