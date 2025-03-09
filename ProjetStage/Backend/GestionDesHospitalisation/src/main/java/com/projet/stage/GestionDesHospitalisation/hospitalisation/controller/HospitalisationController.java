package com.projet.stage.GestionDesHospitalisation.hospitalisation.controller;

import com.projet.stage.GestionDesHospitalisation.hospitalisation.model.Hospitalisation;
import com.projet.stage.GestionDesHospitalisation.hospitalisation.service.HospitalisationService;
import com.projet.stage.GestionDesHospitalisation.lit.model.Lit;
import com.projet.stage.GestionDesHospitalisation.lit.service.LitService;
import com.projet.stage.GestionDesHospitalisation.patient.model.Patient;
import com.projet.stage.GestionDesHospitalisation.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospitalisations")
public class HospitalisationController {
    @Autowired
    private HospitalisationService hospitalisationService;
    @Autowired
    private LitService litService;
    @Autowired
    private PatientService patientService;


    @GetMapping("")
    public ResponseEntity<?> getAllHospitalisations(){
        return ResponseEntity.ok(hospitalisationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHospitalisation(@PathVariable Long id){
        Hospitalisation existing = hospitalisationService.findById(id);
        if(existing != null){
            return ResponseEntity.ok(existing);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hospitalisation introuvable");
        }
    }


    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouter(@RequestParam Long idPatient,@RequestParam Long idLit,@RequestBody Hospitalisation hospitalisation){
        Patient patient = patientService.findById(idPatient);
        Lit lit = litService.findById(idLit);
        if(patient != null && lit != null){
            hospitalisation.setPatient(patient);
            hospitalisation.setLit(lit);
            Hospitalisation create = hospitalisationService.create(hospitalisation);
            if(create != null){
                return ResponseEntity.ok(create);
            }else{
                return ResponseEntity.status(HttpStatus.CONFLICT).body("erreur lors de la creation d'une hospitalisation");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patient ou lit null");
        }
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifier(@PathVariable Long id,@RequestParam Long idPatient,@RequestParam Long idLit,@RequestBody Hospitalisation hospitalisation){
        Hospitalisation existing = hospitalisationService.findById(id);
        if(existing != null){
            Patient patient = patientService.findById(idPatient);
            Lit lit = litService.findById(idLit);
            if(patient != null && lit != null){
                existing.setLit(lit);
                existing.setPatient(patient);
                existing.setDateEntree(hospitalisation.getDateEntree());
                existing.setDateSortie(hospitalisation.getDateSortie());
                Hospitalisation update = hospitalisationService.update(existing);
                if(update != null){
                    return ResponseEntity.ok(update);
                }else{
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("erreur de mise à jour");
                }
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("lit ou patient introuvable");
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hospitalisation inexistante");
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<?> supprimer(@PathVariable Long id){
        Hospitalisation hospitalisation = hospitalisationService.findById(id);
        if(hospitalisation != null){
            hospitalisationService.delete(hospitalisation);
            return ResponseEntity.ok("hospitalisation supprimée");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hospitalisation introuvable");
        }
    }
}
