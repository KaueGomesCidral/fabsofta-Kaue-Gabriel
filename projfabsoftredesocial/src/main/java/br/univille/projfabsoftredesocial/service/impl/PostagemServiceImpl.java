package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.Postagem;
import br.univille.projfabsoftredesocial.repository.PostagemRepository;
import br.univille.projfabsoftredesocial.service.PostagemService;

@Service
public class PostagemServiceImpl implements PostagemService {

    @Autowired
    private PostagemRepository repository;

    @Override
    public Postagem save(Postagem postagem) {
        return repository.save(postagem);
    }

    @Override
    public List<Postagem> getAll() {
        return repository.findAll();
    }

    @Override
    public Postagem getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}