package com.projet.stage.GestionDesBatiments.bureau.service;

import com.projet.stage.GestionDesBatiments.bureau.model.Bureau;
import com.projet.stage.GestionDesBatiments.bureau.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BureauService {
    @Autowired
    private BureauRepository bureauRepository;

    public Bureau create(Bureau bureau){
        return bureauRepository.save(bureau);
    }

    public Bureau update(Bureau existing,Bureau update){
        if(existing.getNumero() != update.getNumero()){
            existing.setNumero(update.getNumero());
        }
        if(existing.getServiceF() != update.getServiceF()){
            existing.setServiceF(update.getServiceF());
        }
        return bureauRepository.save(existing);
    }

    public void delete(Bureau bureau){
        bureauRepository.delete(bureau);
    }

    public List<Bureau> findAll(){
        return bureauRepository.findAll();
    }

    public Bureau findById(Long id){
        return bureauRepository.findById(id).get();
    }

}
