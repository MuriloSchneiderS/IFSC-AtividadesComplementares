package View.Menu;

import Dao.OpcaoFinalDao;
import Model.Aluno;

public class OpcaoFinal extends OpcaoVoltar {
    Aluno aluno;
    public OpcaoFinal(int numero, String titulo, Aluno aluno) {
        super(numero, titulo);
        this.aluno = aluno;
    }

    @Override
    public void exibir() {
        System.out.println("=== PARECER DE VALIDAÇÃO ===");
        new OpcaoFinalDao().emitirUltimoParecer(this.aluno);
        System.out.println("== Menu encerrado. ==");
    }

    
}
