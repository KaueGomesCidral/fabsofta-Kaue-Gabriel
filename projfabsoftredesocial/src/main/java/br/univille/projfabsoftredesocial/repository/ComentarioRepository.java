package br.univille.projfabsoftredesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projfabsoftredesocial.entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}