package View.Menu;

import java.util.ArrayList;
import java.util.List;

import Model.AtividadeComplementar;
import Dao.AtividadeComplementarDao;
import Model.Modalidade;
import Dao.ModalidadeDao;

public class GeraMenu {

    public Menu menuModalidades() {// Menu principal de modalidades
        final int[] c = {1}; // Usando um array para contagem (c está sendo usado dentro de uma classe anônima)
        Menu menuModalidades = new Menu("== Modalidades ==", new ArrayList<ItemMenu>() {{ // Lista de modalidades do menu principal
            List<Modalidade> modalidades = new ModalidadeDao().consultarModalidades();
            for (Modalidade modalidade : modalidades) {
                add(new OpcaoComSubmenu(c[0], modalidade.nome(), new Submenu(modalidade.nome(), new ArrayList<ItemMenu>() {{ // Lista de atividades de ensino
                    List<AtividadeComplementar> atividadesComplementares = new AtividadeComplementarDao().consultarPorModalidade(c[0]);
                    int cc = 1; // Inicializa o contador para as atividades
                    for (AtividadeComplementar atividade : atividadesComplementares) {
                        add(new OpcaoMenu(cc, atividade.descricao() + " (limite: "
                                + atividade.limiteHoras() + "h)"));
                        cc++; // Incrementa o contador de atividades
                    }
                    add(new OpcaoVoltar(0, "Voltar"));
                }})));
                c[0]++; // Incrementa o contador de modalidades
            }
            add(new OpcaoFinal(0, "Finalizar e emitir parecer"));
        }});
        return menuModalidades;
    }
}
