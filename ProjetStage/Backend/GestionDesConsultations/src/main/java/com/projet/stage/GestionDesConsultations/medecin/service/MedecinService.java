package com.projet.stage.GestionDesConsultations.medecin.service;

import com.projet.stage.GestionDesConsultations.medecin.model.Medecin;
import com.projet.stage.GestionDesConsultations.medecin.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;

    public Medecin create(Medecin medecin){
        Medecin existing = medecinRepository.findByMatricule(medecin.getMatricule());
        if(existing != null){
            return null;
        }
        return medecinRepository.save(medecin);
    }

    public Medecin update(Medecin update){
        Medecin existing = medecinRepository.findById(update.getId()).get();
        if(existing != null){
            return medecinRepository.save(update);
        }
        else {
            return null;
        }
    }

    public Medecin activer(Medecin medecin){
        if(medecin.isActive()){
            medecin.setActive(false);
        }else{
            medecin.setActive(true);
        }
        return medecinRepository.save(medecin);
    }

    public void delete(Medecin medecin){
        medecinRepository.delete(medecin);
    }

    public List<Medecin> findAll(){
        return medecinRepository.findAll();
    }

    public Medecin findById(Long id){
        return medecinRepository.findById(id).get();
    }
}
