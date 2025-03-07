package com.projet.stage.GestionDesConsultations.consultation.repository;

import com.projet.stage.GestionDesConsultations.consultation.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
