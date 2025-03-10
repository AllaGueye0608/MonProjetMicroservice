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
    private Long id;
    @Column(nullable = false,unique = true)
    private Long matricule;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private Sexe sexe;
    private String adresse;
    private String telephone;
    @OneToMany(mappedBy = "patient", orphanRemoval = false)
    private List<Consultation> consultations;
    @OneToOne(cascade = CascadeType.REMOVE)
    private DossierMedical dossierMedical;
}