@startuml
package br.univille.projfabsoftredesocial.entity {
    class Usuario {
        + Long id
        + String nome
        + String curso
        + String semestreTurma
        + String telefone
        + String email
        + String senha
        + String bio
        + String atletica
        + List<Postagem> postagens
        + List<Amizade> amigos
    }

    class Postagem {
        + Long id
        + String texto
        + Usuario autor
        + List<Comentario> comentarios
        + List<Long> curtidas
    }

    class Comentario {
        + Long id
        + String texto
        + Usuario autor
        + Postagem postagem
    }

    class MensagemPrivada {
        + Long id
        + String conteudo
        + LocalDateTime dataHora
        + Usuario remetente
        + Usuario destinatario
    }

    class Notificacao {
        + Long id
        + String tipo
        + LocalDateTime dataHora
        + Usuario destinatario
    }

    class Amizade {
        + Long id
        + Usuario usuario
        + Usuario amigo
    }

    class Configuracoes {
        + Long id
        + boolean temaEscuro
        + boolean privacidadeConta
        + boolean notificacoesAtivas
        + Usuario usuario
    }

    Usuario "1" --> "0..*" Postagem : "postagens"
    Usuario "1" --> "0..*" Amizade : "amigos"
    Usuario "1" --> "0..*" Comentario : "autor"
    Usuario "1" --> "0..*" MensagemPrivada : "remetente"
    Usuario "1" --> "0..*" MensagemPrivada : "destinatario"
    Usuario "1" --> "0..*" Notificacao : "destinatario"
    Usuario "1" --> "1" Configuracoes : "configuracoes"
    Postagem "1" --> "0..*" Comentario : "comentarios"
    Postagem "1" --> "1" Usuario : "autor"
    Comentario "1" --> "1" Postagem : "postagem"
}
@enduml