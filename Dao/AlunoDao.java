package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Model.Aluno;

public class AlunoDao {
    Connection conexao;
    private static final Scanner input = new Scanner(System.in);

    public AlunoDao(){
        conexao = ConexaoDao.getConexao();
    }
    
    public Aluno criarAluno(){
        System.out.println("Digite o ID do aluno: ");
        int id = input.nextInt();
        Aluno aluno = consultarAlunoPorId(id);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno.nome() + ", Matrícula: " + aluno.matricula());
            return aluno;
        } else {
            System.out.println("Aluno não encontrado com este id, deseja criar um novo aluno? (S/N)");
            boolean criar = input.next().equalsIgnoreCase("S");
            input.nextLine();
            if (criar) {
                System.out.println("Digite o nome do novo aluno: ");
                String nome = input.nextLine();
                aluno = new Aluno(id, nome);
                return salvar(aluno);
            } else {
                System.out.println("Operação cancelada.");
                return null;
            }
        }
        
    }
    public Aluno consultarAlunoPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = " + id + ";";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            if (rs.next())
                return new Aluno(rs.getInt("id"), rs.getString("nome"));
            else if(id <= 0)
                throw new IllegalArgumentException("ID inválido, não pode ser igual ou menor a zero: " + id);
            else
                System.out.println("Aluno não encontrado com o id: " + id);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Aluno salvar(Aluno aluno){
        String sql = "insert into aluno(nome) values ('"+aluno.nome()+"');";
        try {
            Statement stm = conexao.createStatement();
            stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                aluno = new Aluno(rs.getInt(1), aluno.nome());
                System.out.println("Aluno salvo com sucesso:\n Id:"+aluno.id()+"\n Nome:" + aluno.nome()+",\n Matrícula: " + aluno.matricula());
                return aluno;
            } else {
                System.out.println("Erro ao salvar o aluno.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
}
}