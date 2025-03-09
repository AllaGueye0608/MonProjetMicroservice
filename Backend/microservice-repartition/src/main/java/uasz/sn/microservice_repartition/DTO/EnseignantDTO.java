package uasz.sn.microservice_repartition.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EnseignantDTO {
    private Long id;
    private String prenom;
    private String nom;
}
