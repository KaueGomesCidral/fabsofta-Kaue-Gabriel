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

import br.univille.projfabsoftredesocial.entity.Configuracoes;
import br.univille.projfabsoftredesocial.service.ConfiguracoesService;

@RestController
@RequestMapping("/api/v1/configuracoes")
public class ConfiguracoesController {

    @Autowired
    private ConfiguracoesService service;

    @GetMapping
    public ResponseEntity<List<Configuracoes>> getConfiguracoes() {
        var listaConfiguracoes = service.getAll();
        return new ResponseEntity<>(listaConfiguracoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Configuracoes> postConfiguracoes(@RequestBody Configuracoes configuracoes) {
        if (configuracoes == null) {
            return ResponseEntity.badRequest().build();
        }
        if (configuracoes.getId() == 0) {
            service.save(configuracoes);
            return new ResponseEntity<>(configuracoes, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Configuracoes> putConfiguracoes(@PathVariable long id, @RequestBody Configuracoes configuracoes) {
        if (id <= 0 || configuracoes == null) {
            return ResponseEntity.badRequest().build();
        }
        var configuracoesAntigas = service.getById(id);
        if (configuracoesAntigas == null) {
            return ResponseEntity.notFound().build();
        }

        configuracoesAntigas.setTemaEscuro(configuracoes.isTemaEscuro());
        configuracoesAntigas.setNotificacoesAtivas(configuracoes.isNotificacoesAtivas());

        service.save(configuracoesAntigas);
        return new ResponseEntity<>(configuracoesAntigas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Configuracoes> deleteConfiguracoes(@PathVariable long id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        var configuracoesExcluir = service.getById(id);
        if (configuracoesExcluir == null) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<>(configuracoesExcluir, HttpStatus.OK);
    }
}