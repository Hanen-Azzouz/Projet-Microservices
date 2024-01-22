package esprit.tn.honoraireservice.services;

import esprit.tn.honoraireservice.dto.HonoraireDTO;
import esprit.tn.honoraireservice.dto.MedecinDTO;
import esprit.tn.honoraireservice.entities.Honoraire;
import esprit.tn.honoraireservice.repositories.HonoraireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HonoraireService implements IHonoraireService {

    private  final HonoraireRepository honoraireRepos;
    private final FeignMedecinService feignRepo;



    @Override
    public HonoraireDTO addHonoraire(HonoraireDTO honoraireDTO) {
       Honoraire honoraire =honoraireRepos.save(honoraireDTO.mapToEntity(honoraireDTO));
        MedecinDTO medecinDTO=honoraireDTO.medecinDTO();
        feignRepo.ajouterMedecin(medecinDTO);
        log.info("Honoraire {} is saved",honoraire.getIdHonoraire());
        return honoraireDTO.mapToDTO(honoraire);
    }

    @Override
    public HonoraireDTO findById(long id) {
        Honoraire honoraire=honoraireRepos.findById(id).orElseThrow(()->new IllegalArgumentException("No Honoraire Found with this id"));
        MedecinDTO medecinDTO=feignRepo.findMedecinById(honoraire.getIdMedecin());
        HonoraireDTO honoraireDTO=new HonoraireDTO(honoraire.getIdHonoraire(),honoraire.getDateHonoraire(),honoraire.getMontantHonoraire(),medecinDTO);


        return honoraireDTO;
    }

    @Override
    public Page<HonoraireDTO> findAll(int size, int pagenbr) {
        return honoraireRepos.findAll(PageRequest.of(pagenbr,size)).map(HonoraireDTO::mapToDTO);
    }

    @Override
    public HonoraireDTO updateHonoraire(HonoraireDTO honoraireDTO) {
        Honoraire honoraire=honoraireRepos.save(honoraireDTO.mapToEntity(honoraireDTO));
        return honoraireDTO.mapToDTO(honoraire);
    }

    @Override
    public void deleteHonoraire(long id) {
        honoraireRepos.deleteById(id);
    }

    @Override
    public void deleteHonoraire(HonoraireDTO honoraireDTO) {
        honoraireRepos.delete(honoraireDTO.mapToEntity(honoraireDTO));
    }
}
