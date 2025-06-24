package Model;
public class AtividadeComplementar {
    private String nome;
    private int horasPorAtividade;
    private int limiteMaximo;
    private DocumentacaoComprobatoria documentacaoComprobatoria;

    public AtividadeComplementar(String nome, int horasPorAtividade, DocumentacaoComprobatoria documentacaoComprobatoria) {
        this.nome = nome;
        this.horasPorAtividade = horasPorAtividade;
        this.documentacaoComprobatoria = documentacaoComprobatoria;
    }
}