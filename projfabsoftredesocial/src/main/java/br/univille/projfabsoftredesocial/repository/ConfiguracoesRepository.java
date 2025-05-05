package br.univille.projfabsoftredesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftredesocial.entity.Configuracoes;

@Repository
public interface ConfiguracoesRepository extends JpaRepository<Configuracoes, Long> {
}