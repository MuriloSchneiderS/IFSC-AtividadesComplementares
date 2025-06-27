package View.Menu;

public class OpcaoMenu implements ItemMenu{
    private int numero;
    private String titulo;

    public OpcaoMenu(int numero, String titulo) {
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
