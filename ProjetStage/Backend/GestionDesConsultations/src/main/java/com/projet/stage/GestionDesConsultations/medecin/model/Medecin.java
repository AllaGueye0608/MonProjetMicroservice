package com.projet.stage.GestionDesConsultations.medecin.model;

import com.projet.stage.GestionDesConsultations.Bureau.model.Bureau;
import com.projet.stage.GestionDesConsultations.consultation.model.Consultation;
import com.projet.stage.GestionDesConsultations.patient.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matricule;
    private String prenom;
    private String nom;
    private boolean active;
    @OneToMany(mappedBy = "medecin",orphanRemoval = false)
    private List<Consultation> consultations;
    @OneToOne
    private Bureau bureau;
}
