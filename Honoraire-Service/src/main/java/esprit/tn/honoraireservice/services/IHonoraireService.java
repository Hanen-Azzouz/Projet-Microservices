package esprit.tn.honoraireservice.services;

import esprit.tn.honoraireservice.dto.HonoraireDTO;
import org.springframework.data.domain.Page;

public interface IHonoraireService {
    HonoraireDTO addHonoraire(HonoraireDTO honoraireDTO);
    HonoraireDTO findById(long id);
    Page<HonoraireDTO> findAll(int size,int pagenbr);
    HonoraireDTO updateHonoraire(HonoraireDTO honoraireDTO);
    void deleteHonoraire(long id);
    void deleteHonoraire(HonoraireDTO honoraireDTO);


}
