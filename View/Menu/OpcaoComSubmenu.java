package View.Menu;

public class OpcaoComSubmenu implements ItemMenu {
    private int numero;
    private String titulo;
    private Menu submenu;
    //Possui um submenu, que é um menu dentro deste item de menu
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
        // Exibe o submenu associado a este item de menu
    }

    public Menu submenu() {
        return submenu;
    }
    
}
