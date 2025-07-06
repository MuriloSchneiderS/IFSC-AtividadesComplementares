import java.util.ArrayList;
import java.util.List;

import Model.*;
import Dao.*;
import View.Menu.*;

public class Main {
    public static void main(String[] args) {

        List<AtividadeComplementar> atividadesEnsino = new AtividadeComplementarDao().consultarPorModalidade(1);
        Menu modalidades = new Menu("== Modalidades ==",
                new OpcaoComSubmenu(1, "Ensino", new Submenu("Ensino",
                        new ArrayList<OpcaoMenu>() {
                            {
                                for (AtividadeComplementar atividade : atividadesEnsino) {
                                    add(new OpcaoMenu(1, atividade.descricao()+" (limite: "+atividade.limiteHoras()+"h)"));
                                }
                                add(new OpcaoVoltar(1, "Voltar"));
                            }
                        })),
                new OpcaoFinal(0, "Finalizar e emitir parecer"));

        modalidades.exibir();
    }
}