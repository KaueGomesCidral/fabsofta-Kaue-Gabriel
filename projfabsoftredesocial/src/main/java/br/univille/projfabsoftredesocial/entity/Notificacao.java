package br.univille.projfabsoftredesocial.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private Usuario destinatario;

    // Getters e Setters
}