package com.projet.stage.GestionDesBatiments.bureau.controller;

import com.projet.stage.GestionDesBatiments.bureau.model.Bureau;
import com.projet.stage.GestionDesBatiments.bureau.service.BureauService;
import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import com.projet.stage.GestionDesBatiments.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bureaux")
public class BureauController {
    @Autowired
    private BureauService bureauService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(bureauService.findAll());
    }

    @GetMapping("/esclaves")
    public ResponseEntity<?> getBureauDTOList(){
        return ResponseEntity.ok(bureauService.getBureaux());
    }

    @GetMapping("{id}/esclave")
    public ResponseEntity<?> getBureauDTO(@PathVariable Long id){
        return ResponseEntity.ok(bureauService.getBureau(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBureau(@PathVariable Long id){
        Bureau exising = bureauService.findById(id);
        if(exising != null){
            return ResponseEntity.ok(exising);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bureau inexistant");
        }
    }

    @PostMapping("/{id}/ajouter")
    public ResponseEntity<?> ajouter(@PathVariable Long id,@RequestBody Bureau bureau){
        ServiceF service = serviceService.findById(id);
        if(service != null){
            bureau.setServiceF(service);
            Bureau saved = bureauService.create(bureau);
            if (saved != null){
                return ResponseEntity.ok(saved);
            }else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Bureau existant");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service inexistant");
        }
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestBody Bureau update,@RequestParam(required = true) Long service){
        Bureau existing = bureauService.findById(id);
        if(existing != null){
            ServiceF serviceF = serviceService.findById(service);
            update.setServiceF(serviceF);
            Bureau updated = bureauService.update(existing,update);
            if (updated != null){
                return ResponseEntity.ok(updated);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de la mise à jour");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bureau inexistant");
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
