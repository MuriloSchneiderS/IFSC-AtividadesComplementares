import Dao.AlunoDao;
import View.Menu.GeraMenu;

public class Main {
    public static void main(String[] args) {
        // Cria um aluno e exibe o menu de modalidades
        // O aluno é criado através do AlunoDao e o menu é gerado pela classe menuModalidades
        // O método exibir() do Objeto Menu retornado por menuModalidades é chamado para mostrar o menu
        new GeraMenu().menuModalidades(new AlunoDao().criarAluno()).exibir();
    }
}