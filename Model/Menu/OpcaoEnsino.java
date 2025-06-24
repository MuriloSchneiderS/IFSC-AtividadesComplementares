package Model.Menu;

public class OpcaoEnsino implements ItemMenu {
    private int numero;
    private String titulo;
    private Menu submenu;

    public OpcaoEnsino(int numero, String titulo, Menu submenu) {
        this.numero = numero;
        this.titulo = titulo;
        this.submenu = submenu;
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
        submenu.exibir();
    }
}
