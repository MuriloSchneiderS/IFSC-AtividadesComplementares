package Model;
import Model.Menu.*;
import Model.Menu.SubmenuEnsino.*;

public class Main {
    public static void main(String[] args) {
        Menu modalidades = new Menu("== Modalidades ==",
            new OpcaoEnsino(1, "Ensino"),/*,
            new OpcaoPesquisa(2, "Pesquisa"),
            new OpcaoExtensao(3, "Extensão"),
            new OpcaoComplementacao(4, "Complementação"),*/
            new OpcaoFinal(0, "Finalizar e emitir parecer")
        );

        modalidades.exibir();
    }
}