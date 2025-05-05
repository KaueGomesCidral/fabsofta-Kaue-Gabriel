package br.univille.projfabsoftredesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftredesocial.entity.Amizade;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
}