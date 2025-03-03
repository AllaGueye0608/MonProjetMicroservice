package uasz.sn.microservice_emploiDuTemps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idEnseignant;
    private Long idEnseignement;
    private String type;
    /*private String enseignant;
    private String enseignement;
    */@OneToOne
    private Seance seance;
}
