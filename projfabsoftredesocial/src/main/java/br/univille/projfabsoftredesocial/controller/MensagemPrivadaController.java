package br.univille.projfabsoftredesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftredesocial.entity.MensagemPrivada;
import br.univille.projfabsoftredesocial.service.MensagemPrivadaService;

@RestController
@RequestMapping("/api/v1/mensagens")
public class MensagemPrivadaController {

    @Autowired
    private MensagemPrivadaService service;

    @GetMapping
    public ResponseEntity<List<MensagemPrivada>> getMensagens() {
        var listaMensagens = service.getAll();
        return new ResponseEntity<>(listaMensagens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MensagemPrivada> postMensagem(@RequestBody MensagemPrivada mensagem) {
        if (mensagem == null) {
            return ResponseEntity.badRequest().build();
        }
        if (mensagem.getId() == 0) {
            service.save(mensagem);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensagemPrivada> putMensagem(@PathVariable long id, @RequestBody MensagemPrivada mensagem) {
        if (id <= 0 || mensagem == null) {
            return ResponseEntity.badRequest().build();
        }
        var mensagemAntiga = service.getById(id);
        if (mensagemAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        mensagemAntiga.setDestinatario(mensagem.getDestinatario());

        service.save(mensagemAntiga);
        return new ResponseEntity<>(mensagemAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemPrivada> deleteMensagem(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var mensagemExcluir = service.getById(id);
        if (mensagemExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(mensagemExcluir, HttpStatus.OK);
    }
}