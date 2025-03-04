package com.projet.stage.GestionDesBatiments.lit.model;

import com.projet.stage.GestionDesBatiments.salle.model.Salle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Lit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Exemple: "Médicalisé", "Simple", "Double", "Enfant"

    @Enumerated(EnumType.STRING)
    private EtatLit etat; // DISPONIBLE, OCCUPE, EN_REPARATION

    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = true)
    private Salle salle;
}
