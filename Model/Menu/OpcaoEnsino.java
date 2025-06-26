package Model.Menu;

import Model.Menu.SubmenuEnsino.OpcaoMinistrarReforco;
import Model.Menu.SubmenuEnsino.OpcaoMonitoriaLaboratorio;

public class OpcaoEnsino extends OpcaoComSubmenu{
    public OpcaoEnsino(int numero, String titulo) {
        super(numero, titulo, new Menu("-- Modalidades de Ensino --",
            new OpcaoMinistrarReforco(1, "Ministrar aula de reforço (limite 10h)"),
            new OpcaoMonitoriaLaboratorio(2, "Monitoria de laboratório (limite 15h)"),
            new OpcaoVoltar(0, "Voltar ao menu de modalidades")
        ));
    }
    public OpcaoEnsino(int numero, String titulo, Menu submenu) {
        super(numero, titulo, submenu);
    }
}
