package uasz.sn.microservice_emploiDuTemps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Seance {
    private Long id;
    private String jour;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;
    @OneToOne
    private Repartition repartition;
}
