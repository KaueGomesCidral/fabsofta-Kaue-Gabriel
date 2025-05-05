package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Comentario;
import br.univille.projfabsoftredesocial.repository.ComentarioRepository;
import br.univille.projfabsoftredesocial.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Override
    public Comentario save(Comentario comentario) {
        return repository.save(comentario);
    }

    @Override
    public List<Comentario> getAll() {
        return repository.findAll();
    }

    @Override
    public Comentario getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}