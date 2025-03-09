package uasz.sn.microservice_maquette.GestionEnseignement.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class EnseignementDTO {
    private Long id;
    private String formation;
    private int niveau;
    private int semestre;
    private String nom;
}