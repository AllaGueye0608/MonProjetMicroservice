package com.projet.stage.GestionDesConsultations.medecin.repository;

import com.projet.stage.GestionDesConsultations.medecin.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    public Medecin findByMatricule(Long matricule);
}
