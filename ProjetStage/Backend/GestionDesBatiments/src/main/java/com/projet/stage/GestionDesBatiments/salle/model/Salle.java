package com.projet.stage.GestionDesBatiments.salle.model;

import com.projet.stage.GestionDesBatiments.lit.model.Lit;
import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceF serviceF;

    @OneToMany(mappedBy = "salle", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Lit> lits;
}

