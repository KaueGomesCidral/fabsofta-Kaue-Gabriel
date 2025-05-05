package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Configuracoes;
import br.univille.projfabsoftredesocial.repository.ConfiguracoesRepository;
import br.univille.projfabsoftredesocial.service.ConfiguracoesService;

@Service
public class ConfiguracoesServiceImpl implements ConfiguracoesService {

    @Autowired
    private ConfiguracoesRepository repository;

    @Override
    public Configuracoes save(Configuracoes configuracoes) {
        return repository.save(configuracoes);
    }

    @Override
    public List<Configuracoes> getAll() {
        return repository.findAll();
    }

    @Override
    public Configuracoes getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}