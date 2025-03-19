package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Pessoa;
import br.univille.entity.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

       
        Cidade jlle = new Cidade();
        jlle.setNome("Joinville");
        jlle.setEstado("Santa Catarina");
        Pokemon farfetch = new Pokemon("Farfetch");
        Pokemon gengar = new Pokemon("Gengar");

        Pessoa Gaybiel = new Pessoa("Gaybiel");
        Pessoa Kaue = new Pessoa(); //instancia do objeto
        Kaue.setNome("Kaue");
        Kaue.setCidade(jlle);
        Kaue.getListapokemon().add(farfetch);
        Kaue.getListapokemon().add(gengar);

        
        // For com contador
        for(int i=0; i<Kaue.getListapokemon().size();i++){
            System.out.println(Kaue.getListapokemon().get(i));
        }
        

        // For com iterador
        for(Pokemon umPokemon : Kaue.getListapokemon()){
            System.out.println(umPokemon);
        }

        // For PARADIGMA FUNCIONAL
        Kaue.getListapokemon().stream().forEach(System.out::println);

        System.out.println(Gaybiel);
        System.out.println(Kaue);
    }
}
