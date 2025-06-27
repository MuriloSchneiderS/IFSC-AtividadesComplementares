package View.Menu;

public class OpcaoVoltar implements ItemMenu {
    private int numero;
    private String titulo;

    public OpcaoVoltar(int numero, String titulo) {
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
        System.out.println("Voltando ao menu principal...\n");
    }
}