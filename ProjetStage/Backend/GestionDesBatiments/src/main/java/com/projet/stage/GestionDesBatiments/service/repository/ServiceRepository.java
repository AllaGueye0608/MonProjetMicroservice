package com.projet.stage.GestionDesBatiments.service.repository;

import com.projet.stage.GestionDesBatiments.batiment.model.Batiment;
import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ServiceRepository  extends JpaRepository<ServiceF,Long>{
    List<ServiceF> findByBatiment(Batiment batiment);
    ServiceF findByNom(String nom);
}
