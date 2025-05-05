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

import br.univille.projfabsoftredesocial.entity.Comentario;
import br.univille.projfabsoftredesocial.service.ComentarioService;

@RestController
@RequestMapping("/api/v1/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @GetMapping
    public ResponseEntity<List<Comentario>> getComentarios() {
        var listaComentarios = service.getAll();
        return new ResponseEntity<>(listaComentarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comentario> postComentario(@RequestBody Comentario comentario) {
        if (comentario == null) {
            return ResponseEntity.badRequest().build();
        }
        if (comentario.getId() == 0) {
            service.save(comentario);
            return new ResponseEntity<>(comentario, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> putComentario(@PathVariable long id, @RequestBody Comentario comentario) {
        if (id <= 0 || comentario == null) {
            return ResponseEntity.badRequest().build();
        }
        var comentarioAntigo = service.getById(id);
        if (comentarioAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        comentarioAntigo.setTexto(comentario.getTexto());
        comentarioAntigo.setAutor(comentario.getAutor());
        comentarioAntigo.setPostagem(comentario.getPostagem());

        service.save(comentarioAntigo);
        return new ResponseEntity<>(comentarioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> deleteComentario(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var comentarioExcluir = service.getById(id);
        if (comentarioExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(comentarioExcluir, HttpStatus.OK);
    }
}