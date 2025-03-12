package br.univille;
public class Pessoa { // Formas
    private String nome;  //Variavel - Atributo - Propriedade  // <- Informação

    //Construtor  (mesmo nome da classe, não tem retorno)
    public Pessoa(String nome) {
        //this referencia a classe
        this.nome = nome;
    }
    //dois métodos com assinatura semelhante = polimosfismo
    public Pessoa(){

    }
    //sobreescrita de método (overwrite)
    @Override
    public String toString(){
        return getNome();
    }

    //Método
    public String getNome() {
        return nome;  // <- Ação - Comportamento
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
