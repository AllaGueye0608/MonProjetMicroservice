package com.projet.stage.GestionDesConsultations.dossiermedical.repository;

import com.projet.stage.GestionDesConsultations.dossiermedical.model.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {
    public DossierMedical findByNumeroDossier(Long numeroDossier);
}
