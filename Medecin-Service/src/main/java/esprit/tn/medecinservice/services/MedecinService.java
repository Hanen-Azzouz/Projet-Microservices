package esprit.tn.medecinservice.services;

import esprit.tn.medecinservice.dto.MedecinDTO;
import esprit.tn.medecinservice.entities.Medecin;
import esprit.tn.medecinservice.repositories.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedecinService implements IMedecinService{

    private final MedecinRepository medecinRepos;
    @Override
    public MedecinDTO addMedecin(MedecinDTO medecinDTO) {
        Medecin medecin=medecinRepos.save(MedecinDTO.mapToEntity(medecinDTO));
        return medecinDTO.mapToDTO(medecin);
    }

    @Override
    public MedecinDTO updateMedecin(MedecinDTO medecinDTO) {
      Medecin medecin=medecinRepos.save(medecinDTO.mapToEntity(medecinDTO));
        return medecinDTO.mapToDTO(medecin);
    }

    @Override
    public MedecinDTO findById(long id) {
        Medecin medecin=medecinRepos.findById(id).orElseThrow(()->new IllegalArgumentException("No Medecin found with this id"));

        return MedecinDTO.mapToDTO(medecin);
    }

    @Override
    public Page<MedecinDTO> findAll(int size, int pagenbr) {
        return medecinRepos.findAll(PageRequest.of(pagenbr,size)).map(MedecinDTO::mapToDTO);
    }

    @Override
    public void deleteMedecinById(long id) {
        medecinRepos.deleteById(id);

    }

    @Override
    public void deleteMedecin(MedecinDTO medecinDTO) {
        medecinRepos.delete(medecinDTO.mapToEntity(medecinDTO));
    }
}
