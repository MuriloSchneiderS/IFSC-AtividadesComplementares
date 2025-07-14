package Dao;

import java.sql.Connection;
import java.util.List;

import Model.Aluno;
import Model.AtividadeComplementar;
import Model.AtividadeRealizada;
import Model.Parecer;
import Model.Requerimento;
import Model.ValidacaoAtividade;

public class OpcaoFinalDao {
    Connection conexao;

    public OpcaoFinalDao(){
        conexao = ConexaoDao.getConexao();
    }

    public void emitirUltimoParecer(Aluno aluno){
        System.out.println("Aluno: " + aluno.nome()+", Matrícula: " + aluno.matricula());

        Requerimento ultimoRequerimento = new RequerimentoDao().ultimoRequerimentoDoAluno(aluno.id());
        Parecer ultimoParecer = new ParecerDao().ultimoParecerDoRequerimento(ultimoRequerimento);
        if (ultimoParecer == null) {
            System.out.println("Criação de parecer cancelada, emitindo parecer do último requerimento do aluno.");
            ultimoRequerimento = new RequerimentoDao().penultimoRequerimentoDoAluno(aluno.id());
            ultimoParecer = new ParecerDao().ultimoParecerDoRequerimento(ultimoRequerimento);
        }
        System.out.println("Data emissão: " + ultimoParecer.data_parecer());

        List<AtividadeRealizada> atividadesRealizadas = new AtividadeRealizadaDao().consultarAtividadesRealizadasPorRequerimento(ultimoRequerimento);
        int c = 1, totHorasDeclaradas = 0, totHorasValidadas = 0;
        for (AtividadeRealizada atividadeRealizada : atividadesRealizadas){
            System.out.println("Atividade " + c + ":");
            AtividadeComplementar atividadeComplementar = new AtividadeComplementarDao().consultarPorId(atividadeRealizada.atividade_id());
            System.out.println("  Descrição:       " + atividadeComplementar.descricao());
            System.out.println("  Horas declaradas: " + atividadeRealizada.horas_apresentadas() + "h");
            System.out.println("  Limite Máximo:   " + atividadeComplementar.limite_horas() + "h");
            ValidacaoAtividade validacaoAtividade = new ValidacaoAtividadeDao().consultarValidacaoPorAtividadeRealizada(atividadeRealizada);
            System.out.println("  Horas validadas:  " + validacaoAtividade.horas_validadas() + "h");
            System.out.println(gerarObservacao(atividadeRealizada.horas_apresentadas(), atividadeComplementar.limite_horas()));
            System.out.println("");
            totHorasDeclaradas += atividadeRealizada.horas_apresentadas();
            totHorasValidadas += validacaoAtividade.horas_validadas();
            c++;
        }
        System.out.println("Resumo geral:");
        
        System.out.println("Total de horas declaradas: "+ totHorasDeclaradas + "h");
        System.out.println("Total de horas validadas: "+ totHorasValidadas + "h");
    }

    public String gerarObservacao(int horas_apresentadas, int limite_horas) {
        System.out.print("  Observação:      ");
        if (horas_apresentadas > limite_horas) 
            return "Horas declaradas (" + horas_apresentadas + "h) excedem o limite (" + limite_horas + "h); ajustadas para " + limite_horas + "h.";
        else 
            return "-- (sem ajuste)";
    }
}
