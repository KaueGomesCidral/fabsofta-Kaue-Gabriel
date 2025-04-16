package br.univille.projfabsoftredesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftredesocial.entity.Usuario;
import br.univille.projfabsoftredesocial.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    public ResponseEntity<List<Usuario>> getUsuarios(){
        var listaUsuarios = service.getAll();
        
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }

}
