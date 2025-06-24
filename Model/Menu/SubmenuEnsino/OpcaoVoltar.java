package Model.Menu.SubmenuEnsino;
import Model.Menu.OpcaoFinal;

public class OpcaoVoltar extends OpcaoFinal {
    private int numero;
    private String titulo;

    public OpcaoVoltar(int numero, String titulo) {
        super(numero, titulo);
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
        System.out.println("Voltando ao menu principal...");
    }
}