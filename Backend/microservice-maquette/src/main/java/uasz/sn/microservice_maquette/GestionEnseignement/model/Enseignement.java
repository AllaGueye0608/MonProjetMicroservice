package uasz.sn.microservice_maquette.GestionEnseignement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uasz.sn.microservice_maquette.GestionDesEC.model.EC;
import uasz.sn.microservice_maquette.GestionMaquette.model.Maquette;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"maquette_id", "ec_id"}))
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ec_id", nullable = false)
    private EC ec;

    @ManyToOne
    @JoinColumn(name = "maquette_id", nullable = false)
    private Maquette maquette;
}