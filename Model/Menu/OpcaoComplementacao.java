package Model.Menu;
import Model.Menu.SubmenuComplementacao.*;

public class OpcaoComplementacao extends OpcaoComSubmenu {
    public OpcaoComplementacao(int numero, String titulo) {
        super(numero, titulo, new Menu("-- Atividades de Complementação --",
            new OpcaoPalestraTecnica(1, "Palestra técnica (limite 5h)"),
            new OpcaoVisitaTecnica(2, "Visita técnica (limite 8h)"),
            new OpcaoVoltar(0, "Voltar ao menu de modalidades")
        ));
    }
    public OpcaoComplementacao(int numero, String titulo, Menu submenu) {
        super(numero, titulo, submenu);
    }
    
}
