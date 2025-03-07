package com.projet.stage.GestionDesConsultations.patient.model;

import com.projet.stage.GestionDesConsultations.consultation.model.Consultation;
import com.projet.stage.GestionDesConsultations.dossiermedical.model.DossierMedical;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricule;
    private LocalDate dateNaissance;
    private Sexe sexe;
    private String adresse;
    private String telephone;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private List<Consultation> consultations;
    @OneToOne
    private DossierMedical dossierMedical;
}