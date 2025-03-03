package uasz.sn.microservice_repartition.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uasz.sn.microservice_repartition.DTO.EnseignementDTO;
import uasz.sn.microservice_repartition.model.Enseignement;
import uasz.sn.microservice_repartition.model.EnseignementClient;
import uasz.sn.microservice_repartition.repository.EnseignementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnseignementService {
    @Autowired
    private EnseignementClient enseignementClient;

    @Autowired
    private EnseignementRepository enseignementRepository;

    public Enseignement getEsclaveById(Long id){
        EnseignementDTO enseignementDTO = enseignementClient.getEnseignement(id);
        Enseignement enseignement = new Enseignement();
        enseignement.setId(enseignementDTO.getId());
        enseignement.setNom(enseignementDTO.getNom());enseignement.setFormation(enseignementDTO.getFormation());
        enseignement.setNiveau(enseignementDTO.getNiveau());enseignement.setSemestre(enseignementDTO.getSemestre());
        return enseignement;
    }

    public void saveAll() {
        try {
            ResponseEntity<String> response = enseignementClient.isAvailable();
            if (!response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Microservice indisponible. Annulation de la synchronisation.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la vérification du microservice : " + e.getMessage());
            return;
        }

        List<EnseignementDTO> enseignementDTOList = enseignementClient.getAllEnseignements();
        if (enseignementDTOList == null) {
            System.out.println("Aucun enseignement récupéré.");
            return;
        }

        List<Long> existingIds = enseignementRepository.findAll().stream()
                .map(Enseignement::getId)
                .toList();

        List<Enseignement> enseignementsToSave = new ArrayList<>();
        List<Enseignement> enseignementsToUpdate = new ArrayList<>();

        for (EnseignementDTO dto : enseignementDTOList) {
            if (!existingIds.contains(dto.getId())) {
                Enseignement enseignement = new Enseignement();
                enseignement.setId(dto.getId());
                enseignement.setNom(dto.getNom());
                enseignement.setSemestre(dto.getSemestre());
                enseignement.setFormation(dto.getFormation());
                enseignement.setNiveau(dto.getNiveau());
                enseignementsToSave.add(enseignement);
            } else {
                Enseignement existing = enseignementRepository.findById(dto.getId()).orElse(null);
                if (existing != null && !existing.getNom().equals(dto.getNom())) {
                    existing.setNom(dto.getNom());
                    enseignementsToUpdate.add(existing);
                }
            }
        }

        if (!enseignementsToSave.isEmpty()) {
            enseignementRepository.saveAll(enseignementsToSave);
        }

        if (!enseignementsToUpdate.isEmpty()) {
            enseignementRepository.saveAll(enseignementsToUpdate);
        }
    }




    public  void save(Enseignement enseignement){
        enseignementRepository.save(enseignement);
    }


}
