package br.univille.projfabsoftredesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftredesocial.entity.MensagemPrivada;

@Repository
public interface MensagemPrivadaRepository extends JpaRepository<MensagemPrivada, Long> {
}