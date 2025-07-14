import Dao.AlunoDao;
import View.Menu.GeraMenu;

public class Main {
    public static void main(String[] args) {
        new GeraMenu().menuModalidades(new AlunoDao().criarAluno()).exibir();
    }
}