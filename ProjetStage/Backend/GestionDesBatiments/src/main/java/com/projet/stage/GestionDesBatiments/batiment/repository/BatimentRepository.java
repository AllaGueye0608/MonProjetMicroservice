package com.projet.stage.GestionDesBatiments.batiment.repository;

import com.projet.stage.GestionDesBatiments.batiment.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BatimentRepository extends JpaRepository<Batiment,Long> {
    public Batiment findByNom(String nom);
}
