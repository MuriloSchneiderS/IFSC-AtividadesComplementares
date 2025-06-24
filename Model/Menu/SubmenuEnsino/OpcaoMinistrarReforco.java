package Model.Menu.SubmenuEnsino;
import Model.Menu.ItemMenu;

public class OpcaoMinistrarReforco implements ItemMenu {
    private int numero;
    private String titulo;

    public OpcaoMinistrarReforco(int numero, String titulo) {
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
        System.out.println("ministrar reforço");
    }
}

