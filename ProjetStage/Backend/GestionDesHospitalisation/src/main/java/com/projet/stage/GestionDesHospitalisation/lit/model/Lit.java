package com.projet.stage.GestionDesHospitalisation.lit.model;

import com.projet.stage.GestionDesHospitalisation.hospitalisation.model.Hospitalisation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Lit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private int numero;
    private String salle;
    @OneToMany(mappedBy = "lit", orphanRemoval = false)
    private List<Hospitalisation> hospitalisations;
}
