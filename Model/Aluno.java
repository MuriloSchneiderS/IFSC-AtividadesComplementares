package Model;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    
    public Aluno(String nome) {
        this.nome = nome;
        this.matricula = gerarMatricula();
    }
    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public int id() {
        return id;
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
