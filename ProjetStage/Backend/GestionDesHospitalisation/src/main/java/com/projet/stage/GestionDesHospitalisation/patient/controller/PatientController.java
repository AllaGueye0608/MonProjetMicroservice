package com.projet.stage.GestionDesHospitalisation.patient.controller;

import com.projet.stage.GestionDesHospitalisation.patient.model.Patient;
import com.projet.stage.GestionDesHospitalisation.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("")
    public ResponseEntity<?> getAllPatients(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id){
        Patient existing = patientService.findById(id);
        if(existing != null){
            return ResponseEntity.ok(existing);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient inexistant");
        }
    }
    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(@RequestBody Patient patient){
        Patient create = patientService.create(patient);
        if(create != null){
            return ResponseEntity.ok(patient);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("le patient existe");
        }
    }


    @PutMapping("/{id}/activer")
    public ResponseEntity<?> activerOuDesactiver(@PathVariable Long id){
        Patient existing = patientService.findById(id);
        if(existing != null){
            if(existing.isActive()){
                existing.setActive(false);
            }else{
                existing.setActive(true);
            }
            Patient update = patientService.update(existing);
            if(update != null){
                return ResponseEntity.ok(update);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur de mise à jour");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient inexistant");
        }
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modfier(@PathVariable Long id,@RequestBody Patient patient){
        Patient existing = patientService.findById(id);
        if(existing != null){
            existing.setActive(patient.isActive());
            if(patient.getSexe() != null){
                existing.setSexe(patient.getSexe());
            }
            if(patient.getAdresse() != null){
                existing.setAdresse(patient.getAdresse());
            }
            if(patient.getTelephone() != null){
                existing.setTelephone(patient.getTelephone());
            }
            if(patient.getDateNaissance() != null){
                existing.setDateNaissance(patient.getDateNaissance());
            }
            Patient update = patientService.update(existing);
            if(update != null){
                return ResponseEntity.ok(update);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de la mise en jour");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient inexistant");
        }
    }
    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> supprimer(@PathVariable Long id) {
        Patient existing = patientService.findById(id);
        if (existing != null) {
            patientService.delete(existing);
            return ResponseEntity.ok("patient supprimé");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient inexistant");
        }
    }

}
