package com.projet.stage.GestionDesBatiments.lit.repository;

import com.projet.stage.GestionDesBatiments.lit.model.Lit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LitRepository extends JpaRepository<Lit,Long> {
}
