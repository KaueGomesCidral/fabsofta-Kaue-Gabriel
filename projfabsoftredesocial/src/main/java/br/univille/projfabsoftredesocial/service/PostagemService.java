package br.univille.projfabsoftredesocial.service;

import java.util.List;
import br.univille.projfabsoftredesocial.entity.Postagem;

public interface PostagemService {
    Postagem save(Postagem postagem);
    List<Postagem> getAll();
    Postagem getById(long id);
    void delete(long id);
}