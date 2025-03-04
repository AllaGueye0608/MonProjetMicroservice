package uasz.sn.microservice_maquette.GestionClasse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.microservice_maquette.GestionFormation.model.Formation;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "classe",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"formation_id", "niveau"})
        }
)
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private int niveau;
    @ManyToOne
    @JoinColumn(name = "formation_id", nullable = false)
    private Formation formation;

    private boolean  archive;
}
