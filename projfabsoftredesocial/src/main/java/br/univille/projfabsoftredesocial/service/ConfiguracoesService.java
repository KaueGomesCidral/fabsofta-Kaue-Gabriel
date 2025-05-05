package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.Configuracoes;

public interface ConfiguracoesService {
    Configuracoes save(Configuracoes configuracoes);
    List<Configuracoes> getAll();
    Configuracoes getById(long id);
    void delete(long id);
}