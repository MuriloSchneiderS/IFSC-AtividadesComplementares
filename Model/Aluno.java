package Model;

public class Aluno {
    private String nome;
    private String matricula;
    public Aluno(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
        this.matricula = gerarMatricula();
    }

    public String nome(){
        return nome;
    }
    public String matricula() {
        return matricula;
    }
    private static String gerarMatricula() {
        return String.format("%09d", (int)(Math.random() * 1_000_000_000));
    }
}
