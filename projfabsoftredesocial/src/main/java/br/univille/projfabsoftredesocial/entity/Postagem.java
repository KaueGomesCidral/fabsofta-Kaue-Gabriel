package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    @ElementCollection
    private List<Long> curtidas;


     // Getters e Setters
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Long> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Long> curtidas) {
        this.curtidas = curtidas;
    }

   
    
}