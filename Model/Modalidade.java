package Model;

public class Modalidade {
    private int id;
    private String nome;
    public Modalidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String nome(){
        return nome;
    }
}
