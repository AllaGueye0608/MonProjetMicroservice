package com.projet.stage.GestionDesHospitalisation.lit.repository;

import com.projet.stage.GestionDesHospitalisation.lit.model.Lit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LitRepository extends JpaRepository<Lit,Long> {
}
