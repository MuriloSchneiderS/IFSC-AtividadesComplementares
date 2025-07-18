package Model;

public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    
    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.matricula = gerarMatricula();
    }
    public Aluno(String nome){
        this.nome = nome;
        this.matricula = gerarMatricula();
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
        // Matrícula aleatória para exemplo
        return String.format("%09d", (int)(Math.random() * 1_000_000_000));
    }
}
