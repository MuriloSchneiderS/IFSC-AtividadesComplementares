package View.Menu;

import Dao.OpcaoFinalDao;

public class OpcaoFinal extends OpcaoVoltar {
    public OpcaoFinal(int numero, String titulo) {
        super(numero, titulo);
    }

    @Override
    public void exibir() {
        System.out.println("=== PARECER DE VALIDAÇÃO ===");
        new OpcaoFinalDao().emitirUltimoParecer();
        System.out.println("== Menu encerrado. ==");
    }
}
