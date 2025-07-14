package View.Menu;

import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.AtividadeComplementar;
import Dao.AtividadeComplementarDao;
import Model.Modalidade;
import Model.Requerimento;
import Dao.ModalidadeDao;
import Dao.RequerimentoDao;

public class GeraMenu {

    public Menu menuModalidades(Aluno aluno) {// Menu principal de modalidades e submenus com suas atividades
        if (aluno==null)
            throw new IllegalArgumentException("Operação cancelada -Aluno não encontrado.");
        Menu menuModalidades = new Menu("== Modalidades ==", new ArrayList<ItemMenu>() {{ // Lista de modalidades do menu principal
            final int[] c = {1}; // Usando um array para contagem (c está sendo usado dentro de uma classe anônima)
            Requerimento requerimento = new RequerimentoDao().insertRequerimento(aluno); // Cria um requerimento para o aluno
            List<Modalidade> modalidades = new ModalidadeDao().consultarModalidades(); // Consulta as modalidades disponíveis
            for (Modalidade modalidade : modalidades) { // Loop que cria as opções de menu para cada modalidade
                add(new OpcaoComSubmenu(c[0], modalidade.nome(), new Menu(modalidade.nome(), new ArrayList<ItemMenu>() {{ // Cria a opção da modalidade e um submenu com as atividades da modalidade
                    List<AtividadeComplementar> atividadesComplementares = new AtividadeComplementarDao().consultarPorModalidade(c[0]);
                    int cc = 1; // Inicializa o contador para as atividades
                    for (AtividadeComplementar atividade : atividadesComplementares) {
                        add(new OpcaoMenuAtividadesComplementares(cc, atividade, requerimento));
                        cc++; // Incrementa o contador de atividades
                    }
                    add(new OpcaoVoltar(0, "Voltar"));
                }})));
                c[0]++; // Incrementa o contador de modalidades
            }
            add(new OpcaoFinal(0, "Finalizar e emitir parecer", aluno));
        }});
        return menuModalidades;
    }
}
