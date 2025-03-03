package uasz.sn.microservice_repartition.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Enseignement {
    @Id
    private Long id;
    private String formation;
    private int niveau;
    private int semestre;
    private String nom;
    @ManyToMany(mappedBy = "enseignements", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Enseignant> enseignants = new ArrayList<>();
}
