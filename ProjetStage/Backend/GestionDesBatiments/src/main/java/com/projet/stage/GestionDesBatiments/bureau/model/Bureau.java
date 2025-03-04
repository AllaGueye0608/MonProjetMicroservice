package com.projet.stage.GestionDesBatiments.bureau.model;

import com.projet.stage.GestionDesBatiments.service.model.ServiceF;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Bureau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceF serviceF;
}
