package com.projet.stage.GestionDesBatiments.bureau.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BureauDTO {
    private Long id;
    private int numero;
    private String service;
}
