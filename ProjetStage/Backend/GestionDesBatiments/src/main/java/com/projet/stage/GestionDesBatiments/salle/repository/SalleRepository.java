package com.projet.stage.GestionDesBatiments.salle.repository;

import com.projet.stage.GestionDesBatiments.salle.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
}
