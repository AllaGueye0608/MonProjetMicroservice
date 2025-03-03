package uasz.sn.microservice_emploiDuTemps.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Gestion-Repartition-Microservice", url = "http://localhost:8083")
public interface RepartitionClient {
    @GetMapping("/choix")
    List<Repartition> getAll();

    @GetMapping("/choix/{id}")
    Repartition getRepartition(@PathVariable Long id);

    @GetMapping("/choix/{id}/info")
    List<String> getTypeEnseignantEnseignement(@PathVariable Long id);

}
