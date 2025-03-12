package br.univille;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        Pessoa Gaybiel = new Pessoa("Gaybiel");
        Pessoa Kaue = new Pessoa(); //instancia do objeto
        Kaue.setNome("Kaue");
        
        
        System.out.println(Gaybiel);
        System.out.println(Kaue);
    }
}
