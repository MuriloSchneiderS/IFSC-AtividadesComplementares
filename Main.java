import View.Menu.*;

public class Main {
    public static void main(String[] args) {
        
        Menu modalidades = new Menu("== Modalidades ==",
            new OpcaoComSubmenu(1,"Ensino",new Menu("Ensino", 
                new OpcaoMenu(1, ""),
                new OpcaoMenu(2, "")
            )),
            new OpcaoFinal(0, "Finalizar e emitir parecer")
        );

        modalidades.exibir();
    }
}