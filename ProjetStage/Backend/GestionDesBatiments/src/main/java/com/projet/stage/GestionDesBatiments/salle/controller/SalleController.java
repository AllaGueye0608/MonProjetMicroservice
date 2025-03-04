package com.projet.stage.GestionDesBatiments.salle.controller;

import com.projet.stage.GestionDesBatiments.salle.model.Salle;
import com.projet.stage.GestionDesBatiments.salle.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;

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
}
