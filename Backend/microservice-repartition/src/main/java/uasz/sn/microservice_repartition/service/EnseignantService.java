package uasz.sn.microservice_repartition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uasz.sn.microservice_repartition.DTO.EnseignantDTO;
import uasz.sn.microservice_repartition.DTO.EnseignementDTO;
import uasz.sn.microservice_repartition.model.Enseignant;
import uasz.sn.microservice_repartition.model.EnseignantClient;
import uasz.sn.microservice_repartition.model.Enseignement;
import uasz.sn.microservice_repartition.repository.EnseignantRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantClient enseignantClient;
    @Autowired
    private EnseignantRepository enseignantRepository;

    /*public Enseignant findById(Long id){
        return enseignantClient.getEnseignant(id);
    }*/

    /*public List<Enseignant> getAll(){
        return enseignantClient.getEnseignant();
    }*/
    /*public void save(Enseignant enseignant){

        List<String> infos = enseignantClient.getInfo(enseignant.getId());
        enseignant.setNom(infos.get(0));
        enseignant.setPrenom(infos.get(1));
        enseignantRepository.save(enseignant);

    }*/


    /*@Scheduled(fixedRate = 10000)  // Exécuter toutes les 10 000 millisecondes (10s)
    public List<Enseignant> saveAll() {
        try {
            // Récupérer tous les enseignants existants dans la base de données
            List<Enseignant> existingEnseignants = enseignantRepository.findAll();
            Set<Long> existingIds = existingEnseignants.stream()
                    .map(Enseignant::getId)
                    .collect(Collectors.toSet());

            // Récupérer tous les enseignants depuis le client externe
            List<EnseignantDTO> enseignantsFromClient = enseignantClient.getEnseignants();

            // Ajouter seulement ceux qui n'existent pas encore dans la base
            for (EnseignantDTO enseignantDTO : enseignantsFromClient) {
                if (!existingIds.contains(enseignantDTO.getId())) {
                    Enseignant enseignant = new Enseignant();
                    enseignant.setId(enseignantDTO.getId());
                    enseignant.setPrenom(enseignantDTO.getPrenom());
                    enseignant.setNom(enseignantDTO.getNom());

                    // Sauvegarder l'enseignant dans la base
                    enseignantRepository.save(enseignant);
                    // Ajoutez l'ID dans le Set pour éviter de traiter à nouveau le même enseignant
                    existingIds.add(enseignantDTO.getId());
                }
            }

            // Retourner la liste mise à jour des enseignants
            return enseignantRepository.findAll();
        } catch (Exception e) {
            // Gérer l'exception et loguer l'erreur si nécessaire
            e.printStackTrace();
            return null;  // ou une autre valeur en fonction de la logique souhaitée
        }
    }*/
    public void save(Enseignant enseignant){
        enseignantRepository.save(enseignant);
    }
}
