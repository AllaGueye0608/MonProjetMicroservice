package com.projet.stage.GestionDesConsultations.Bureau.model;

import com.projet.stage.GestionDesConsultations.medecin.model.Medecin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Bureau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long numero;
    private String service;
    @OneToOne
    private Medecin medecin;
}
