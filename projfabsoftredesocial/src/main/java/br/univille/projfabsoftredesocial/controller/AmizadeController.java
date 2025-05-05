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

import br.univille.projfabsoftredesocial.entity.Amizade;
import br.univille.projfabsoftredesocial.service.AmizadeService;

@RestController
@RequestMapping("/api/v1/amizades")
public class AmizadeController {

    @Autowired
    private AmizadeService service;

    @GetMapping
    public ResponseEntity<List<Amizade>> getAmizades() {
        var listaAmizades = service.getAll();
        return new ResponseEntity<>(listaAmizades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Amizade> postAmizade(@RequestBody Amizade amizade) {
        if (amizade == null) {
            return ResponseEntity.badRequest().build();
        }
        if (amizade.getId() == 0) {
            service.save(amizade);
            return new ResponseEntity<>(amizade, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amizade> putAmizade(@PathVariable long id, @RequestBody Amizade amizade) {
        if (id <= 0 || amizade == null) {
            return ResponseEntity.badRequest().build();
        }
        var amizadeAntiga = service.getById(id);
        if (amizadeAntiga == null) {
            return ResponseEntity.notFound().build();
        }

        amizadeAntiga.setUsuario(amizade.getUsuario());
        amizadeAntiga.setAmigo(amizade.getAmigo());

        service.save(amizadeAntiga);
        return new ResponseEntity<>(amizadeAntiga, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Amizade> deleteAmizade(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var amizadeExcluir = service.getById(id);
        if (amizadeExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(amizadeExcluir, HttpStatus.OK);
    }
}