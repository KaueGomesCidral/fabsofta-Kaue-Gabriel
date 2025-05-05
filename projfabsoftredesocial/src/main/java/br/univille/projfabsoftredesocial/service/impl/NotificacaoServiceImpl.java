package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Notificacao;
import br.univille.projfabsoftredesocial.repository.NotificacaoRepository;
import br.univille.projfabsoftredesocial.service.NotificacaoService;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private NotificacaoRepository repository;

    @Override
    public Notificacao save(Notificacao notificacao) {
        return repository.save(notificacao);
    }

    @Override
    public List<Notificacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Notificacao getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}