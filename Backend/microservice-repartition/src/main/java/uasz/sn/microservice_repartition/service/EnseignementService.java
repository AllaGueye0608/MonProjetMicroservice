package uasz.sn.microservice_repartition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uasz.sn.microservice_repartition.DTO.EnseignementDTO;
import uasz.sn.microservice_repartition.model.Enseignement;
import uasz.sn.microservice_repartition.model.EnseignementClient;
import uasz.sn.microservice_repartition.repository.EnseignementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnseignementService {
    @Autowired
    private EnseignementClient enseignementClient;

    @Autowired
    private EnseignementRepository enseignementRepository;

    public EnseignementDTO findById(Long id){
        return enseignementClient.getEnseignement(id);
    }

    @Scheduled(fixedRate = 10000)  // Exécuter toutes les 10 000 millisecondes (10s)
    public List<Enseignement> saveAll() {
        // Récupérer tous les enseignements existants dans la base de données
        List<Enseignement> existingEnseignements = enseignementRepository.findAll();

        // Utiliser un Set pour vérifier plus efficacement l'existence
        Set<Long> existingIds = existingEnseignements.stream()
                .map(Enseignement::getId)
                .collect(Collectors.toSet());

        // Récupérer tous les enseignements depuis le client externe
        List<EnseignementDTO> enseignementsFromClient = enseignementClient.getAllEnseignements();

        // Ajouter seulement ceux qui n'existent pas encore dans la base
        for (EnseignementDTO enseignementDTO : enseignementsFromClient) {
            if (!existingIds.contains(enseignementDTO.getId())) {
                Enseignement enseignement = new Enseignement();
                enseignement.setId(enseignementDTO.getId());
                enseignement.setFormation(enseignementDTO.getFormation());
                enseignement.setSemestre(enseignementDTO.getSemestre());
                enseignement.setNiveau(enseignementDTO.getNiveau());
                enseignement.setNom(enseignementDTO.getNom());
                enseignementRepository.save(enseignement);
            }
        }

        // Retourner la liste mise à jour des enseignements
        return enseignementRepository.findAll();
    }


    public  void save(Enseignement enseignement){
        enseignementRepository.save(enseignement);
    }
}