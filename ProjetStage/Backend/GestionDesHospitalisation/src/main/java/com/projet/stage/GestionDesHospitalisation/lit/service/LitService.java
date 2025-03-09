package com.projet.stage.GestionDesHospitalisation.lit.service;

import com.projet.stage.GestionDesHospitalisation.lit.model.Lit;
import com.projet.stage.GestionDesHospitalisation.lit.repository.LitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LitService {
    @Autowired
    private LitRepository litRepository;

    public Lit create(Lit lit){
        return litRepository.save(lit);
    }


    public Lit update(Lit lit){
       Lit existing = litRepository.findById(lit.getId()).get();
       if(existing == null){
           return null;
       }
        return litRepository.save(lit);
    }

    public void delete(Lit lit){
        litRepository.delete(lit);
    }

    public List<Lit> findAll(){
        return litRepository.findAll();
    }

    public Lit findById(Long id){
        return litRepository.findById(id).get();
    }
}
