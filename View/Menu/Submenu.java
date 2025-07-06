package View.Menu;

import java.util.ArrayList;

public class Submenu extends Menu {
    private ArrayList<OpcaoMenu> itensDeSubmenu;

    public Submenu(String titulo, ArrayList<OpcaoMenu> itens) {
        super(titulo);
        this.itensDeSubmenu = itens;
    }

    @Override
    public void exibir() {
        super.exibir();
    }
    
}
