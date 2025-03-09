package com.projet.stage.GestionDesConsultations.Bureau.controller;

import com.projet.stage.GestionDesConsultations.Bureau.model.Bureau;
import com.projet.stage.GestionDesConsultations.Bureau.service.BureauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bureaux")
public class BureauController {
    @Autowired
    private BureauService bureauService;

    @GetMapping("")
    public ResponseEntity<?> getAllBureau(){
        return ResponseEntity.ok(bureauService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBureau(@PathVariable Long id){
        Bureau existing = bureauService.findById(id);
        if(existing != null){
            return ResponseEntity.ok(existing);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("le bureau n'existe pas");
        }
    }

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(Bureau bureau){
        Bureau create = bureauService.create(bureau);
        if(create != null){
            return ResponseEntity.ok(create);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("bureau existe déja");
        }
    }


    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestBody Bureau update){
        Bureau existing = bureauService.findById(id);
        if(existing != null){
            existing.setService(update.getService());
            existing.setNumero(update.getNumero());
            Bureau updated = bureauService.update(existing);
            if(updated != null){
                return ResponseEntity.ok(updated);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors du mise à jour");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bureau inexistant");
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> supprimer(@PathVariable Long id){
        Bureau bureau = bureauService.findById(id);
        if(bureau != null){
            bureauService.delete(bureau);
            return ResponseEntity.ok("bureau supprimé");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bureau inexistant");
        }
    }

}
