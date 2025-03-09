package com.projet.stage.GestionDesHospitalisation.lit.service;

import com.projet.stage.GestionDesHospitalisation.lit.repository.LitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitService {
    @Autowired
    private LitRepository litRepository;
    
}
