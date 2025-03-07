package com.projet.stage.GestionDesConsultations.Bureau.repository;

import com.projet.stage.GestionDesConsultations.Bureau.model.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BureauRepository extends JpaRepository<Bureau,Long> {
    public Bureau findByNumero(Long numero);
}
