package com.projet.stage.GestionDesHospitalisation.patient.repository;

import com.projet.stage.GestionDesHospitalisation.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByMatricule(Long matricule);
}
