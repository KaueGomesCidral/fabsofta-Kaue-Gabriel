package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.Amizade;

public interface AmizadeService {
    Amizade save(Amizade amizade);
    List<Amizade> getAll();
    Amizade getById(long id);
    void delete(long id);
}