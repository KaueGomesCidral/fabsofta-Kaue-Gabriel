package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Amizade;
import br.univille.projfabsoftredesocial.repository.AmizadeRepository;
import br.univille.projfabsoftredesocial.service.AmizadeService;

@Service
public class AmizadeServiceImpl implements AmizadeService {

    @Autowired
    private AmizadeRepository repository;

    @Override
    public Amizade save(Amizade amizade) {
        return repository.save(amizade);
    }

    @Override
    public List<Amizade> getAll() {
        return repository.findAll();
    }

    @Override
    public Amizade getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}