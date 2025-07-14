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
        Aluno aluno = consultarAlunoPorId(id);// Consulta o aluno pelo ID fornecido
        if (aluno != null) {// Se o aluno for encontrado
            System.out.println("Aluno encontrado: " + aluno.nome() + ", Matrícula: " + aluno.matricula());
            return aluno;// Retorna o aluno encontrado
        } else {// Se o aluno não for encontrado
            System.out.println("Aluno não encontrado com este id, deseja criar um novo aluno? (S/N)");
            boolean criar = input.next().equalsIgnoreCase("S");
            input.nextLine();
            if (criar) {// Se o usuário optar por criar um novo aluno
                System.out.println("Digite o nome do novo aluno: ");
                String nome = input.nextLine();
                aluno = new Aluno(id, nome);
                return salvar(aluno);// Salva o novo aluno no banco de dados e retorna o objeto Aluno
            } else {// Se o usuário optar por não criar um novo aluno
                System.out.println("Operação cancelada.");
                return null;
            }
        }
    }
    public Aluno consultarAlunoPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = " + id + ";";
        try {
            ResultSet rs = conexao.createStatement().executeQuery(sql);
            if (rs.next())// Se houver um resultado na consulta pelo ID
                return new Aluno(rs.getInt("id"), rs.getString("nome"));// Cria e retorna um objeto Aluno com os dados retornados
            else if(id <= 0)// Se o ID for inválido (menor ou igual a zero)
                throw new IllegalArgumentException("ID inválido, não pode ser igual ou menor a zero: " + id);
            else// Se não houver resultado, significa que o aluno não foi encontrado
                System.out.println("Aluno não encontrado com o id: " + id);
            return null;// Retorna null se o aluno não for encontrado ou o ID for inválido
        } catch (SQLException e) {// Se ocorrer um erro ao executar a consulta SQL
            e.printStackTrace();
            return null;
        }
    }
    public Aluno salvar(Aluno aluno){
        String sql = "insert into aluno(nome) values ('"+aluno.nome()+"');";
        try {
            Statement stm = conexao.createStatement();
            // Executa a inserção do aluno e obtém a chave gerada automaticamente
            stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            // O método getGeneratedKeys() é usado para recuperar a chave primária gerada após a inserção, que é o ID do aluno.
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){// Se a inserção for bem-sucedida e houver uma chave gerada
                aluno = new Aluno(rs.getInt(1), aluno.nome());// Cria um novo objeto Aluno com o ID gerado e o nome fornecido
                System.out.println("Aluno salvo com sucesso:\n Id:"+aluno.id()+"\n Nome:" + aluno.nome()+",\n Matrícula: " + aluno.matricula());
                return aluno;// Retorna o objeto Aluno com o ID gerado
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