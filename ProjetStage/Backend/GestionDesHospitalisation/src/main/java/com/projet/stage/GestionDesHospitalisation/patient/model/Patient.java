package com.projet.stage.GestionDesHospitalisation.patient.model;

import com.projet.stage.GestionDesHospitalisation.hospitalisation.model.Hospitalisation;
import com.projet.stage.GestionDesHospitalisation.lit.model.Lit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private Long matricule;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    private String sexe;
    private String adresse;
    private String telephone;
    private boolean active;

    @OneToMany(mappedBy = "patient", orphanRemoval = false)
    private List<Hospitalisation> hospitalisations;

}
