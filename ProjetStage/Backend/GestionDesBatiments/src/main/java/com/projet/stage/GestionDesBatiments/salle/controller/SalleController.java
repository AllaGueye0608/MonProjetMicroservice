package com.projet.stage.GestionDesBatiments.salle.controller;

import com.projet.stage.GestionDesBatiments.salle.model.Salle;
import com.projet.stage.GestionDesBatiments.salle.service.SalleService;
import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import com.projet.stage.GestionDesBatiments.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(salleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalle(@PathVariable Long id){
        Salle salle = salleService.findById(id);
        if(salle != null){
            return ResponseEntity.ok(salle);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("salle inexistante");
        }
    }

    @PostMapping("/{id}/ajouter")
    public ResponseEntity<?> ajouter(@PathVariable Long id,@RequestBody Salle salle){
        ServiceF service = serviceService.findById(id);
        if(service != null){
            salle.setServiceF(service);
            Salle create = salleService.create(salle);
            if(create != null){
                return ResponseEntity.ok(create);
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Salle existe déja");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service inexistant");
        }
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestBody Salle update,@RequestParam(required = true) Long service){
        Salle existing = salleService.findById(id);
        if(existing != null){
            if(service != null){
                ServiceF s = serviceService.findById(service);
                update.setServiceF(s);
            }
            Salle updated = salleService.update(existing,update);
            if(updated != null){
                return ResponseEntity.ok(updated);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("echec lors de la mise à jour");
            }
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Salle introuvable");
        }
    }
    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Salle salle = salleService.findById(id);
        if(salle != null){
            salleService.delete(salle);
            return ResponseEntity.ok("salle supprimée");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("salle inexistante");
        }
    }
}
