package uasz.sn.microservice_maquette.GestionEnseignement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uasz.sn.microservice_maquette.GestionEnseignement.DTO.EnseignementDTO;
import uasz.sn.microservice_maquette.GestionEnseignement.service.EnseignementService;

import java.util.List;

@RestController
@RequestMapping("/enseignements")
public class EnseignementController {
    @Autowired
    private EnseignementService enseignementService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(enseignementService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        EnseignementDTO enseignement = enseignementService.getEnseignementDTO(id);
        if (enseignement == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("L'enseignement avec l'ID " + id + " n'existe pas.");
        }
        return ResponseEntity.ok(enseignement);
    }

    @GetMapping("/esclaves")
    public ResponseEntity<?> getAllEnseignements() {
        List<EnseignementDTO> enseignementDTOS = enseignementService.getEnseignementsDTO();
        return ResponseEntity.ok(enseignementDTOS);
    }
}
