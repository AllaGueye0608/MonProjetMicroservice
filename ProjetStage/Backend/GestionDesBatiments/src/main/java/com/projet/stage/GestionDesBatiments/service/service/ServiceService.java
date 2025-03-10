package com.projet.stage.GestionDesBatiments.service.service;

import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import com.projet.stage.GestionDesBatiments.service.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceF create(ServiceF service){
        ServiceF existing = serviceRepository.findByNom(service.getNom());
        if(existing != null){
            return null;
        }else {
            return serviceRepository.save(service);
        }
    }

    public ServiceF update(ServiceF existing, ServiceF update){
        if(!existing.getNom().equals(update.getNom()) && !update.getNom().isEmpty()){
            existing.setNom(update.getNom());
        }
        if(existing.getBatiment() != update.getBatiment() && update.getBatiment() != null){
            existing.setBatiment(update.getBatiment());
        }
        return serviceRepository.save(existing);
    }

    public  void delete(ServiceF serviceF){
        serviceRepository.delete(serviceF);
    }

    public List<ServiceF> findAll(){
        return serviceRepository.findAll();
    }

    public ServiceF findById(Long id){
        return serviceRepository.findById(id).get();
    }

    public List<ServiceF> findAllIds(List<Long> ids){
        return serviceRepository.findAllById(ids);
    }
}
