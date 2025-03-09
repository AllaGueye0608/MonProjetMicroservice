package uasz.sn.microservice_maquette.GestionEnseignement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uasz.sn.microservice_maquette.GestionEnseignement.DTO.EnseignementDTO;
import uasz.sn.microservice_maquette.GestionEnseignement.model.Enseignement;
import uasz.sn.microservice_maquette.GestionEnseignement.repository.EnseignementRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnseignementService {
    @Autowired
    private EnseignementRepository enseignementRepository;

    public Enseignement create(Enseignement enseignement){
        return enseignementRepository.save(enseignement);
    }

    public EnseignementDTO getEnseignementDTO(Long id) {
        Optional<Enseignement> optionalEnseignement = enseignementRepository.findById(id);

        if (optionalEnseignement.isEmpty()) {
            System.out.println("Aucun enseignement trouvé pour l'ID : " + id);
            return null;  // Retourne null au lieu de lever une exception
        }

        Enseignement enseignement = optionalEnseignement.get();
        EnseignementDTO enseignementDTO = new EnseignementDTO();

        enseignementDTO.setId(enseignement.getId());
        enseignementDTO.setNiveau(enseignement.getMaquette().getClasse().getNiveau());
        enseignementDTO.setFormation(enseignement.getMaquette().getClasse().getFormation().getIntitule());
        enseignementDTO.setSemestre(enseignement.getMaquette().getSemestre());
        enseignementDTO.setNom(enseignement.getEc().getIntitule());

        return enseignementDTO;
    }


    public List<EnseignementDTO> getEnseignementsDTO() {
        List<Enseignement> enseignements = enseignementRepository.findAll();
        List<EnseignementDTO> enseignementDTOS = new ArrayList<>();

        for (Enseignement e : enseignements) {
            if (e != null) {
                EnseignementDTO enseignementDTO = new EnseignementDTO(
                        e.getId(),
                        e.getMaquette().getClasse().getFormation().getIntitule(),
                        e.getMaquette().getClasse().getNiveau(),
                        e.getMaquette().getSemestre(),
                        e.getEc().getIntitule()
                );
                enseignementDTOS.add(enseignementDTO);
            }
        }

        return enseignementDTOS;
    }


    public boolean Exist(Long ec, Long maquette){
        if(enseignementRepository.findByEcIdAndMaquetteId(ec,maquette) != null){
            return true;
        }else {
            return false;
        }
    }
    public Enseignement update(Enseignement enseignement){
        Enseignement existing = enseignementRepository.findById(enseignement.getId()).get();
       return (enseignement == null ? null : enseignementRepository.save(enseignement));
    }

    public void delete(Enseignement enseignement){
        enseignementRepository.delete(enseignement);
    }

    public List<Enseignement> findAll(){
        return enseignementRepository.findAll();
    }

    public   Enseignement findById(Long id){
        return enseignementRepository.findById(id).get();
    }

    public Enseignement findByEcAndMaquette(Long ec,Long maquette){
        return enseignementRepository.findByEcIdAndMaquetteId(ec,maquette);
    }

    public List<Enseignement> findByMaquette(Long maquette){
        return enseignementRepository.findByMaquetteId(maquette);
    }

    public List<Enseignement> findByEc(Long ec){
        return enseignementRepository.findByEcId(ec);
    }
}
