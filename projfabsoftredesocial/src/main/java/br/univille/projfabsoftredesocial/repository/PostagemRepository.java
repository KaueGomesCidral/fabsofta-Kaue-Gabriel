package br.univille.projfabsoftredesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projfabsoftredesocial.entity.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    
}
