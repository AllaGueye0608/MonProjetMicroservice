package com.projet.stage.GestionDesBatiments.lit.service;

import com.projet.stage.GestionDesBatiments.lit.model.Lit;
import com.projet.stage.GestionDesBatiments.lit.repository.LitRepository;
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

    public Lit update(Lit existing,Lit update){
        if(!existing.getType().equals(update.getType())){
            existing.setType(update.getType());
        }
        if(!existing.getEtat().equals(update.getEtat())){
            existing.setEtat(update.getEtat());
        }
        if(existing.getSalle() != update.getSalle()){
            existing.setSalle(update.getSalle());
        }
        return litRepository.save(existing);
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
