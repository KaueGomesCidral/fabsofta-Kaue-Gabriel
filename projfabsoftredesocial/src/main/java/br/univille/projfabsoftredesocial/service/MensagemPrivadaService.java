package br.univille.projfabsoftredesocial.service;

import java.util.List;

import br.univille.projfabsoftredesocial.entity.MensagemPrivada;

public interface MensagemPrivadaService {
    MensagemPrivada save(MensagemPrivada mensagem);
    List<MensagemPrivada> getAll();
    MensagemPrivada getById(long id);
    void delete(long id);
}