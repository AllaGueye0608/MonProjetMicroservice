package uasz.sn.microservice_repartition.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class EnseignementDTO {
    private Long id;
    private String formation;
    private int niveau;
    private int semestre;
    private String nom;
}
