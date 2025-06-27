package View.Menu;

public class OpcaoFinal extends OpcaoVoltar {
    public OpcaoFinal(int numero, String titulo) {
        super(numero, titulo);
    }

    @Override
    public void exibir() {
        System.out.println("== Menu encerrado. ==");
    }
}
