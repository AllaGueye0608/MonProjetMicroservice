package com.projet.stage.GestionDesBatiments.batiment.service;

import com.projet.stage.GestionDesBatiments.batiment.model.Batiment;
import com.projet.stage.GestionDesBatiments.batiment.repository.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    public Batiment create(Batiment batiment){
        Batiment existing = batimentRepository.findByNom(batiment.getNom());
        if(existing != null){
            return null;
        }
        return batimentRepository.save(batiment);
    }

    public Batiment update(Batiment existing ,Batiment batiment){
        if(!existing.getNom().equals(batiment.getNom()) && !batiment.getNom().isEmpty()){
                existing.setNom(batiment.getNom());
        }
        if(existing.getServiceFS() != batiment.getServiceFS()){
            existing.setServiceFS(batiment.getServiceFS());
        }
        return batimentRepository.save(existing);
    }

    public void delete(Batiment existing){
        if(existing != null){
            batimentRepository.delete(existing);
        }
    }

    public Batiment findByid(Long id){
        return batimentRepository.findById(id).get();
    }

    public List<Batiment> findAll(){
        return batimentRepository.findAll();
    }

    public List<Batiment> findAllIds(List<Long> ids){
        return batimentRepository.findAllById(ids);
    }


}
