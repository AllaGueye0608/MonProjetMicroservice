package uasz.sn.microservice_emploiDuTemps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uasz.sn.microservice_emploiDuTemps.model.Repartition;

@RepositoryRestResource
public interface RepartitionRepository  extends JpaRepository<Repartition,Long> {
}
