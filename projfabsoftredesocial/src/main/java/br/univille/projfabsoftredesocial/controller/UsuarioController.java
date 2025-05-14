package br.univille.projfabsoftredesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoftredesocial.entity.Usuario;
import br.univille.projfabsoftredesocial.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios(){
        var listaUsuarios = service.getAll();
        
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }
        if(usuario.getId() == 0){
            service.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        if(id <= 0 || usuario == null){
            return ResponseEntity.badRequest().build();
        }
        var usuarioAntigo = service.getById(id);
        if (usuarioAntigo == null){
            return ResponseEntity.notFound().build();
        }

        usuarioAntigo.setNome(usuario.getNome());
        usuarioAntigo.setCurso(usuario.getCurso());
        usuarioAntigo.setSemestreTurma(usuario.getSemestreTurma());
        usuarioAntigo.setTelefone(usuario.getTelefone());
        usuarioAntigo.setEmail(usuario.getEmail());
        usuarioAntigo.setSenha(usuario.getSenha());
        usuarioAntigo.setBio(usuario.getBio());
        usuarioAntigo.setAtletica(usuario.getAtletica());
        usuarioAntigo.setDataNascimento(usuario.getDataNascimento());
        usuarioAntigo.setAmigos(usuario.getAmigos());

        service.save(usuarioAntigo);
        return new ResponseEntity<Usuario>(usuarioAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id){
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        var usuarioExcluir = service.getById(id);
        if (usuarioExcluir == null){
            return ResponseEntity.notFound().build();
        }

        service.delete(id);
        return new ResponseEntity<Usuario>(usuarioExcluir, HttpStatus.OK);
    }
}