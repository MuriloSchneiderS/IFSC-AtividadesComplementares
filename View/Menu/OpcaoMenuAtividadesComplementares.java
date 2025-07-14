package View.Menu;

import java.util.Scanner;

import Dao.AtividadeRealizadaDao;
import Dao.ParecerDao;
import Dao.ValidacaoAtividadeDao;
import Model.AtividadeComplementar;
import Model.AtividadeRealizada;
import Model.Parecer;
import Model.Requerimento;

public class OpcaoMenuAtividadesComplementares implements ItemMenu{
    private int numero;
    private String titulo;
    private AtividadeComplementar atividadeComplementar;
    private Requerimento requerimento;
    Scanner input = new Scanner(System.in);

    public OpcaoMenuAtividadesComplementares(int numero, AtividadeComplementar atividadeComplementar, Requerimento requerimento) {
        this.numero = numero;
        this.atividadeComplementar = atividadeComplementar;
        this.requerimento = requerimento;
        this.titulo = atividadeComplementar.descricao() + " (limite: " + atividadeComplementar.limite_horas() + "h)";
    }

    @Override
    public int numero() {
        return numero;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public void exibir() {
        System.out.println("Horas declaradas para "+titulo+":");
        int horas_declaradas = input.nextInt();

        AtividadeRealizada atividadeRealizada = new AtividadeRealizadaDao().insertAtividadeRealizada(requerimento, atividadeComplementar, horas_declaradas);
        Parecer parecer = new ParecerDao().ultimoParecerDoRequerimento(requerimento);
        new ValidacaoAtividadeDao().insertValidacaoAtividade(atividadeRealizada, atividadeComplementar, parecer, horas_declaradas);

        System.out.println("Atividade adicionada ao requerimento.\n--------------------------");
    }
}
