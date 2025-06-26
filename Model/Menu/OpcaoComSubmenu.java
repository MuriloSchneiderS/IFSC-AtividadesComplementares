package Model.Menu;

public abstract class OpcaoComSubmenu implements ItemMenu {
    private int numero;
    private String titulo;
    private Menu submenu;

    public OpcaoComSubmenu(int numero, String titulo, Menu submenu) {
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

    public Menu submenu() {
        return submenu;
    }
    
}
