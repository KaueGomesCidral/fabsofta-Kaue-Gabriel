package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String curso;
    private String semestreTurma;
    private String telefone;
    private String email;
    private String senha;
    private String bio;
    private String atletica;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Amizade> amigos;

    // Getters e Setters
}