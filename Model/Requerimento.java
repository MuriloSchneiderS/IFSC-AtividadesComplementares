package Model;

public class Requerimento {
    public int id;
    public int alunoId;
    public String data_requerimento;
    public String status;
    public String data_validacao;
    public Requerimento(int id, int alunoId, String data_requerimento, String status, String data_validacao) {
        this.id = id;
        this.alunoId = alunoId;
        this.data_requerimento = data_requerimento;
        this.status = status;
        this.data_validacao = data_validacao;
    }

    public int id() {
        return id;
    }
}
