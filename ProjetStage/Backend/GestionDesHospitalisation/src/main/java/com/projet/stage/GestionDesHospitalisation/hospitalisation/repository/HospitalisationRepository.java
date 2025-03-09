package com.projet.stage.GestionDesHospitalisation.hospitalisation.repository;

import com.projet.stage.GestionDesHospitalisation.hospitalisation.model.Hospitalisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HospitalisationRepository extends JpaRepository<Hospitalisation,Long> {
}
