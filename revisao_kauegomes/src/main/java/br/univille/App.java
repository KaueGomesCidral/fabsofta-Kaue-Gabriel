package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        Pessoa Gaybiel = new Pessoa("Gaybiel");
        Pessoa Kaue = new Pessoa(); //instancia do objeto
        Kaue.setNome("Kaue");
        Cidade jlle = new Cidade();
        jlle.setNome("Joinville");
        jlle.setEstado("Santa Catarina");
        
        System.out.println(Gaybiel);
        System.out.println(Kaue);
    }
}
