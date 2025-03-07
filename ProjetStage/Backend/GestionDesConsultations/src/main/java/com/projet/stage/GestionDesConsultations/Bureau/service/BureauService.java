package com.projet.stage.GestionDesConsultations.Bureau.service;

import com.projet.stage.GestionDesConsultations.Bureau.model.Bureau;
import com.projet.stage.GestionDesConsultations.Bureau.model.BureauClient;
import com.projet.stage.GestionDesConsultations.Bureau.repository.BureauRepository;
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
        if(!existing.getService().equals(update.getService())){
            existing.setService(update.getService());
        }

        return bureauRepository.save(existing);

    }

    public void delete(Bureau bureau){
        bureauRepository.delete(bureau);
    }

    public List<Bureau> findAll(){
        return bureauRepository.findAll();
    }

    public Bureau findById(Long numero){
        return bureauRepository.findByNumero(numero);
    }
}
