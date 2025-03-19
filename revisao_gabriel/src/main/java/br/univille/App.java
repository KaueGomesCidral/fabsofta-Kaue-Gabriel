package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Pessoa;
import br.univille.entity.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Olá Mundo!");
        Cidade jlle = new Cidade();
        jlle.setNome("Joinville");
        jlle.setEstado(("Santa Catarina"));

        Pokemon lucario = new Pokemon("Lucario");
        Pokemon dewott = new Pokemon("Dewott");

        Pessoa mariazinha = new Pessoa("Mariazinha");
        Pessoa zezinho = new Pessoa();
        zezinho.setNome("Zezinho");
        //zezinho.setCidade(jlle);
        zezinho.getListaPokemon().add(lucario);
        zezinho.getListaPokemon().add(dewott);
        //zezinho.getListaPokemon().add(123);

        for (var umPokemon : zezinho.getListaPokemon()) {
            System.out.println(umPokemon);
        }

        System.out.println(mariazinha);
        System.out.println(zezinho);
    }
}