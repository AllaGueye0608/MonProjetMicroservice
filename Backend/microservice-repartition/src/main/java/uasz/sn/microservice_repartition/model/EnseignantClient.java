package uasz.sn.microservice_repartition.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uasz.sn.microservice_repartition.DTO.EnseignantDTO;

import java.util.List;

@FeignClient(name="microservice-utilisateur", url = "http://localhost:8084")
public interface EnseignantClient {
    @GetMapping("/ChefDepartements/enseignants/{id}")
    EnseignantDTO getEnseignant(@PathVariable Long id);

    @GetMapping("/ChefDepartements/enseignants")
    List<EnseignantDTO> getEnseignants();

}