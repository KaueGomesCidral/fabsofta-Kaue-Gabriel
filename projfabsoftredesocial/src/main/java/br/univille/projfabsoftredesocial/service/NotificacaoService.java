package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.Notificacao;

public interface NotificacaoService {
    Notificacao save(Notificacao notificacao);
    List<Notificacao> getAll();
    Notificacao getById(long id);
    void delete(long id);
}