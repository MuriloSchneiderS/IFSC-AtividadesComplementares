package Model.Menu;

public class OpcaoComplementacao implements ItemMenu {
    private int numero;
    private String titulo;

    public OpcaoComplementacao(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
    }

    @Override
    public int numero() {
        return numero;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public void exibir() {

    }
}
