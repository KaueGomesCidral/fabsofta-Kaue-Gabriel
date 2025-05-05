package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.Comentario;

public interface ComentarioService {
    Comentario save(Comentario comentario);
    List<Comentario> getAll();
    Comentario getById(long id);
    void delete(long id);
}