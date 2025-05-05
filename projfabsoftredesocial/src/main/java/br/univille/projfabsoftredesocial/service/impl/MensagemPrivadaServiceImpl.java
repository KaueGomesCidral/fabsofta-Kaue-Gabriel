package br.univille.projfabsoftredesocial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoftredesocial.entity.MensagemPrivada;
import br.univille.projfabsoftredesocial.repository.MensagemPrivadaRepository;
import br.univille.projfabsoftredesocial.service.MensagemPrivadaService;

@Service
public class MensagemPrivadaServiceImpl implements MensagemPrivadaService {

    @Autowired
    private MensagemPrivadaRepository repository;

    @Override
    public MensagemPrivada save(MensagemPrivada mensagem) {
        return repository.save(mensagem);
    }

    @Override
    public List<MensagemPrivada> getAll() {
        return repository.findAll();
    }

    @Override
    public MensagemPrivada getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}