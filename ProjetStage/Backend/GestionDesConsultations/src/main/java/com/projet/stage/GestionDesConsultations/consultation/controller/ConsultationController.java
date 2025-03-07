package com.projet.stage.GestionDesConsultations.consultation.controller;

import com.projet.stage.GestionDesConsultations.consultation.model.Consultation;
import com.projet.stage.GestionDesConsultations.consultation.service.ConsultationService;
import com.projet.stage.GestionDesConsultations.medecin.model.Medecin;
import com.projet.stage.GestionDesConsultations.medecin.service.MedecinService;
import com.projet.stage.GestionDesConsultations.patient.model.Patient;
import com.projet.stage.GestionDesConsultations.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private MedecinService medecinService;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(consultationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsultation(@PathVariable Long id){
        Consultation existing = consultationService.findById(id);
        if(existing != null){
            return ResponseEntity.ok(existing);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Consultation inexistante");
        }
    }

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(@RequestParam(required = true) Long idMedecin,@RequestParam(required = true) Long idPatient){
        Patient existingPatient = patientService.findById(idPatient);
        Medecin existingMedecin = medecinService.findById(idMedecin);
        if(existingMedecin != null && existingMedecin != null){
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(LocalDate.now());
            consultation.setMedecin(existingMedecin);
            consultation.setPatient(existingPatient);
            Consultation create = consultationService.create(consultation);
            if(create != null){
                return ResponseEntity.ok(create);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body("erreur lors de la creation de consultation");
            }
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medecin ou patient inexistant");
        }
    }


    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestParam(required = true) Long idMedecin,@RequestParam(required = true) Long idPatient,@RequestBody Consultation update){
        Consultation existing = consultationService.findById(id);
        if(existing != null){
            Patient existingPatient = patientService.findById(idPatient);
            Medecin existingMedecin = medecinService.findById(idMedecin);
            if(existingMedecin != null && existingMedecin != null){
                update.setPatient(existingPatient);update.setMedecin(existingMedecin);
                update.setDateConsultation(LocalDate.now());
                Consultation updated = consultationService.update(update);
                if(updated != null){
                    return ResponseEntity.ok(updated);
                }else{
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("erreur lors de la mise à jour de la consultation");
                }
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medecin ou patient inexistant");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("consultation inexistante");
        }
    }

    @PutMapping("/{id}/suivi")
    public ResponseEntity<?> suivi(@PathVariable Long id){
        Consultation consultation = consultationService.suivi(id);

        if(consultation != null){
            return ResponseEntity.ok(consultation);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("consultation inexistante");
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Consultation consultation = consultationService.findById(id);
        if(consultation != null){
            consultationService.delete(consultation);
            return ResponseEntity.ok("consultation supprimée");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("consultation inexistante");
        }
    }
}
