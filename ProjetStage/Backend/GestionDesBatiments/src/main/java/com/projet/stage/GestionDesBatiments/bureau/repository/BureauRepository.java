package com.projet.stage.GestionDesBatiments.bureau.repository;

import com.projet.stage.GestionDesBatiments.bureau.model.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BureauRepository extends JpaRepository<Bureau,Long> {
}
