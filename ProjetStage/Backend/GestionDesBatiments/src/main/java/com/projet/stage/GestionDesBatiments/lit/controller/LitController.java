package com.projet.stage.GestionDesBatiments.lit.controller;

import com.projet.stage.GestionDesBatiments.lit.model.Lit;
import com.projet.stage.GestionDesBatiments.lit.service.LitService;
import com.projet.stage.GestionDesBatiments.salle.model.Salle;
import com.projet.stage.GestionDesBatiments.salle.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lits")
public class LitController {
    @Autowired
    private LitService litService;
    @Autowired
    private SalleService salleService;

    @GetMapping("")
    public ResponseEntity<?> getLits(){
        return ResponseEntity.ok(litService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLit(@PathVariable Long id){
        Lit lit = litService.findById(id);
        if(lit != null){
            return ResponseEntity.ok(lit);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lit introuvable");
        }
    }

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(@RequestParam Long id,@RequestBody Lit lit){
        if(id != null){
            Salle salle = salleService.findById(id);
            if(salle != null){
                lit.setSalle(salle);
            }
        }
        Lit created = litService.create(lit);
        if(created != null){
            return ResponseEntity.ok(created);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("lit existant");
        }

    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestBody Lit update){
        Lit existing = litService.findById(id);
        if(existing != null){
            Lit updated = litService.update(existing,update);
            if(updated != null){
                return ResponseEntity.ok(updated);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de la mise à jour");
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lit inexistant");
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> supprimer(@PathVariable Long id){
        Lit lit = litService.findById(id);
        if(lit != null){
            litService.delete(lit);
            return ResponseEntity.ok("lit supprimé");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lit introuvable");
        }
    }
}
