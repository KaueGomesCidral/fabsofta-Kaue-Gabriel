package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;

@Entity
public class Configuracoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean temaEscuro; // true para tema escuro, false para tema claro
    private boolean privacidadeConta; // true para conta privada, false para pública
    private boolean notificacoesAtivas; // true para ativar notificações, false para desativar

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    // Getters e Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTemaEscuro() {
        return temaEscuro;
    }

    public void setTemaEscuro(boolean temaEscuro) {
        this.temaEscuro = temaEscuro;
    }

    public boolean isPrivacidadeConta() {
        return privacidadeConta;
    }

    public void setPrivacidadeConta(boolean privacidadeConta) {
        this.privacidadeConta = privacidadeConta;
    }

    public boolean isNotificacoesAtivas() {
        return notificacoesAtivas;
    }

    public void setNotificacoesAtivas(boolean notificacoesAtivas) {
        this.notificacoesAtivas = notificacoesAtivas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}