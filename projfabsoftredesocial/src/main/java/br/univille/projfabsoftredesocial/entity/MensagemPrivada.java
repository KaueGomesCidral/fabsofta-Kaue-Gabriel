package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MensagemPrivada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Usuario destinatario;

    // Getters e Setters
}