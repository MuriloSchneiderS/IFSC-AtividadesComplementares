package Model;

import java.util.List;

public class Modalidade{
    private String nome;
    private List<AtividadeComplementar> atividadesComplementares;

    public Modalidade(String nome) {
        this.nome = nome;
    }

    public boolean add(AtividadeComplementar atividadeComplementar) {
        return atividadesComplementares.add(atividadeComplementar);
    }
}