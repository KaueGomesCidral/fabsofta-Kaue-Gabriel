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

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters e Setters
}