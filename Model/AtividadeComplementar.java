package Model;

public class AtividadeComplementar {
    private int id;
    private String descricao;
    private int limiteHoras;
    public AtividadeComplementar(int id, String descricao, int limiteHoras) {
        this.id = id;
        this.descricao = descricao;
        this.limiteHoras = limiteHoras;
    }

    public String descricao() {
        return descricao;
    }
    public int limiteHoras() {
        return limiteHoras;
    }
}
