package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false )
    private String nome;
    private String curso;
    private String semestreTurma;
    private String telefone;
    private String email;
    private String senha;
    private String bio;
    private String atletica;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;



    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Amizade> amigos;


     // Getters e Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSemestreTurma() {
        return semestreTurma;
    }

    public void setSemestreTurma(String semestreTurma) {
        this.semestreTurma = semestreTurma;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAtletica() {
        return atletica;
    }

    public void setAtletica(String atletica) {
        this.atletica = atletica;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Amizade> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Amizade> amigos) {
        this.amigos = amigos;
    }

   
    
}