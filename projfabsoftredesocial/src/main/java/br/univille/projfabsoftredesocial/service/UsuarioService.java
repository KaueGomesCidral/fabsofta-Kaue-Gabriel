package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.Usuario;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(long id);
    Usuario delete(long id);
}
