package br.univille.projfabsoftredesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.univille.projfabsoftredesocial.entity.Postagem;
import br.univille.projfabsoftredesocial.service.PostagemService;

@RestController
@RequestMapping("/api/v1/postagens")
public class PostagemController {

    @Autowired
    private PostagemService service;

    @GetMapping
    public ResponseEntity<List<Postagem>> getPostagens() {
        var listaPostagens = service.getAll();
        return new ResponseEntity<>(listaPostagens, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {
        if (postagem == null) {
            return ResponseEntity.badRequest().build();
        }
        if (postagem.getId() == 0) {
            service.save(postagem);
            return new ResponseEntity<>(postagem, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> putPostagem(@PathVariable long id, @RequestBody Postagem postagem) {
        if (id <= 0 || postagem == null) {
            return ResponseEntity.badRequest().build();
        }
        var postagemAntiga = service.getById(id);
        if (postagemAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        postagemAntiga.setTexto(postagem.getTexto());
        postagemAntiga.setAutor(postagem.getAutor());
        postagemAntiga.setComentarios(postagem.getComentarios());
        postagemAntiga.setCurtidas(postagem.getCurtidas());

        service.save(postagemAntiga);
        return new ResponseEntity<>(postagemAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Postagem> deletePostagem(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var postagemExcluir = service.getById(id);
        if (postagemExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(postagemExcluir, HttpStatus.OK);
    }
}
