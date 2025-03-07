package com.projet.stage.GestionDesConsultations.patient.service;

import com.projet.stage.GestionDesConsultations.patient.model.Patient;
import com.projet.stage.GestionDesConsultations.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient update(Patient update){
        Patient existing = patientRepository.findByMatricule(update.getMatricule());
        if(existing != null){
            return patientRepository.save(update);
        }else {
            return null;
        }
    }

    public void delete(Patient patient){
        patientRepository.delete(patient);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Patient findById(Long matricule){
        return patientRepository.findByMatricule(matricule);
    }
}
