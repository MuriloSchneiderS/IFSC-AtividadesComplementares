package Model;

public class AtividadeRealizada {
    private int id;
    private int requerimento_id;
    private int atividade_id;
    private int horas_apresentadas;
    private String documento;
    public AtividadeRealizada(int id, int requerimento_id, int atividade_id, int horas_apresentadas, String documento) {
        this.id = id;
        this.requerimento_id = requerimento_id;
        this.atividade_id = atividade_id;
        this.horas_apresentadas = horas_apresentadas;
        this.documento = documento;
    }

    public int id() {
        return id;
    }
    public int atividade_id() {
        return atividade_id;
    }
    public int horas_apresentadas() {
        return horas_apresentadas;
    }
}
