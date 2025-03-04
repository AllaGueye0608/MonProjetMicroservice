package uasz.sn.microservice_maquette.GestionClasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uasz.sn.microservice_maquette.GestionClasse.model.Classe;

@RepositoryRestResource
public interface ClasseRepository extends JpaRepository<Classe,Long> {
}
