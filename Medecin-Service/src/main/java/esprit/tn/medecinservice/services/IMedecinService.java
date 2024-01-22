package esprit.tn.medecinservice.services;

import esprit.tn.medecinservice.dto.MedecinDTO;
import org.springframework.data.domain.Page;

public interface IMedecinService {

    MedecinDTO addMedecin(MedecinDTO medecinDTO);
    MedecinDTO updateMedecin(MedecinDTO medecinDTO);
    MedecinDTO findById(long id);
    Page<MedecinDTO> findAll(int size,int pagenbr);
    void deleteMedecinById(long id);
    void deleteMedecin(MedecinDTO medecinDTO);


}
