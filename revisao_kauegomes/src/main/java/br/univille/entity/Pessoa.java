package br.univille.entity;

import java.util.ArrayList;

public class Pessoa { // Formas

    private String nome;  //Variavel - Atributo - Propriedade  // <- Informação
    private long id;
    private String endereco;
    
    private Cidade cidade;
    private ArrayList<Pokemon> listapokemon = new ArrayList<Pokemon>();
    

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

    // Getter e Setter Nome

    //Método
    public String getNome() {
        return nome;  // <- Ação - Comportamento
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter ID

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter e Setter Endereço

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter Cidade

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    

    // Getter e Setter listapokemon

    public ArrayList<Pokemon> getListapokemon() {
        return listapokemon;
    }
    public void setListapokemon(ArrayList<Pokemon> listapokemon) {
        this.listapokemon = listapokemon;
    }
    

}
