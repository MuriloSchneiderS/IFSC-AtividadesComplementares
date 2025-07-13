package Model;

public class AtividadeComplementar {
    private int id;
    private String descricao;
    private int limite_horas;
    public AtividadeComplementar(int id, String descricao, int limite_horas) {
        this.id = id;
        this.descricao = descricao;
        this.limite_horas = limite_horas;
    }

    public int id() {
        return id;
    }
    public String descricao() {
        return descricao;
    }
    public int limite_horas() {
        return limite_horas;
    }
}
