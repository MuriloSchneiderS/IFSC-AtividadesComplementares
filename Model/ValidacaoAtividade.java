package Model;

public class ValidacaoAtividade {
    private int id;
    private int atividade_realizada_id;
    private int horas_validadas;
    private int parecer_id;
    public ValidacaoAtividade(int id, int atividade_realizada_id, int horas_validadas, int parecer_id) {
        this.id = id;
        this.atividade_realizada_id = atividade_realizada_id;
        this.horas_validadas = horas_validadas;
        this.parecer_id = parecer_id;
    }

    public int id() {
        return id;
    }
    public int horas_validadas() {
        return horas_validadas;
    }
}
