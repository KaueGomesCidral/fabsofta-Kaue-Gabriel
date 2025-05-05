package br.univille.projfabsoftredesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftredesocial.entity.Notificacao;
import br.univille.projfabsoftredesocial.service.NotificacaoService;

@RestController
@RequestMapping("/api/v1/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;

    @GetMapping
    public ResponseEntity<List<Notificacao>> getNotificacoes() {
        var listaNotificacoes = service.getAll();
        return new ResponseEntity<>(listaNotificacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notificacao> postNotificacao(@RequestBody Notificacao notificacao) {
        if (notificacao == null) {
            return ResponseEntity.badRequest().build();
        }
        if (notificacao.getId() == 0) {
            service.save(notificacao);
            return new ResponseEntity<>(notificacao, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> putNotificacao(@PathVariable long id, @RequestBody Notificacao notificacao) {
        if (id <= 0 || notificacao == null) {
            return ResponseEntity.badRequest().build();
        }
        var notificacaoAntiga = service.getById(id);
        if (notificacaoAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        notificacaoAntiga.setMensagem(notificacao.getMensagem());
        notificacaoAntiga.setUsuario(notificacao.getUsuario());

        service.save(notificacaoAntiga);
        return new ResponseEntity<>(notificacaoAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notificacao> deleteNotificacao(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var notificacaoExcluir = service.getById(id);
        if (notificacaoExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(notificacaoExcluir, HttpStatus.OK);
    }
}