package Model.Menu.SubmenuComplementacao;
import Model.Menu.ItemMenu;

public class OpcaoVisitaTecnica implements ItemMenu {
    private int numero;
    private String titulo;

    public OpcaoVisitaTecnica(int numero, String titulo) {
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
        System.out.println("Executando visita técnica: " + titulo);
    }
    
}
