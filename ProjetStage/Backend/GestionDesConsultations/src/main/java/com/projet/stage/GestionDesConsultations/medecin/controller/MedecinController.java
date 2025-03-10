package com.projet.stage.GestionDesConsultations.medecin.controller;

import com.projet.stage.GestionDesConsultations.Bureau.model.Bureau;
import com.projet.stage.GestionDesConsultations.Bureau.service.BureauService;
import com.projet.stage.GestionDesConsultations.medecin.model.Medecin;
import com.projet.stage.GestionDesConsultations.medecin.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medecins")
public class MedecinController {
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private BureauService bureauService;

    @GetMapping("")
    public ResponseEntity<?> getAllMedecin(){
        return ResponseEntity.ok(medecinService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMedecin(@PathVariable Long id){
        Medecin existing = medecinService.findById(id);
        if(existing != null){
            return ResponseEntity.ok(existing);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("medecin inexistant");
        }
    }

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(@RequestParam Long idBureau,@RequestBody Medecin medecin){
        Bureau bureau = bureauService.findById(idBureau);
        if(bureau!= null){
            medecin.setBureau(bureau);
            Medecin create = medecinService.create(medecin);
            if(create != null){
                return ResponseEntity.ok(create);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body("le medecin existe déja ou bien le bureau est déja attribué à un autre medecin");
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bureau inexistant");
        }
    }

    @PutMapping("{id}/activer")
    public ResponseEntity<?> activer(@PathVariable Long id){
        Medecin existing = medecinService.findById(id);
        if(existing != null){
            Medecin active = medecinService.activer(existing);
            if(active != null){
                return ResponseEntity.ok(active);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("mauvaise requete");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("medecin inexistant");
        }
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestParam Long idBureau,@RequestBody Medecin update){
        Medecin existing = medecinService.findById(id);
        if(existing != null){
            Bureau bureau = bureauService.findById(idBureau);
            if(bureau != null){
                existing.setBureau(bureau);
                existing.setNom(update.getNom());
                existing.setPrenom(update.getPrenom());
                existing.setActive(update.isActive());
                Medecin updated = medecinService.update(existing);
                if(updated != null){
                    return ResponseEntity.ok(updated);
                }else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("soit le medecin n'existe pas soit le bureau est déja attribué à un autre medecin");
                }
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bureau inexistant");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("medecin inexistant");
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> supprimer(@PathVariable Long id){
        Medecin medecin = medecinService.findById(id);
        if(medecin != null){
            medecinService.delete(medecin);
            return ResponseEntity.ok("medecin supprimé");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("medecin inexistant");
        }
    }
}

