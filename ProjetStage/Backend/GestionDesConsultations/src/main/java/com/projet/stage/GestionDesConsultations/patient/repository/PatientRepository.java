package com.projet.stage.GestionDesConsultations.patient.repository;

import com.projet.stage.GestionDesConsultations.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient,Long> {
    public Patient findByMatricule(Long matricule);
}
