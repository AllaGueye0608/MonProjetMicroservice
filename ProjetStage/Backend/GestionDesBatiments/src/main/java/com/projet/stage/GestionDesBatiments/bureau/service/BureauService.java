package com.projet.stage.GestionDesBatiments.bureau.service;

import com.projet.stage.GestionDesBatiments.bureau.DTO.BureauDTO;
import com.projet.stage.GestionDesBatiments.bureau.model.Bureau;
import com.projet.stage.GestionDesBatiments.bureau.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public BureauDTO getBureau(Long id){
        Bureau bureau = bureauRepository.findById(id).get();
        BureauDTO bureauDTO = new BureauDTO();
        bureauDTO.setId(bureau.getId());bureauDTO.setNumero(bureau.getNumero());
        bureauDTO.setService(bureau.getServiceF().getNom());
        return bureauDTO;
    }

    public List<BureauDTO> getBureaux(){
        List<Bureau> bureauList = bureauRepository.findAll();
        List<BureauDTO> bureauDTOList = new ArrayList<>();
        for(Bureau b : bureauList){
            BureauDTO bureauDTO = getBureau(b.getId());
            bureauDTOList.add(bureauDTO);
        }
        return bureauDTOList;
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
