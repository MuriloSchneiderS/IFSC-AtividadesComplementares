package Model.Menu.SubmenuEnsino;
import Model.Menu.ItemMenu;

public class OpcaoMonitoriaLaboratorio implements ItemMenu {
    private int numero;
    private String titulo;

    public OpcaoMonitoriaLaboratorio(int numero, String titulo) {
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

