package esprit.tn.mshonorairequery.services;


import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairequery.entities.Honoraire;
import esprit.tn.mshonorairequery.repositories.HonoraireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class HonoraireQueryService implements IHonoraireQueryService {
    private  final HonoraireRepository honoraireRepos;

    @Override
    public Honoraire add(Honoraire honoraire) {
        honoraire.setDateHonoraire(LocalDateTime.now());
        return honoraireRepos.save(honoraire);
    }

    @Override
    public Honoraire update(Honoraire honoraire) {
        return honoraireRepos.save(honoraire);
    }


    @Override
    public boolean delete(long idHonoraire) {
        honoraireRepos.deleteById(idHonoraire);
        return honoraireRepos.existsById(idHonoraire);
    }

    @Override
    public Page<HonoraireDto> getHonoraires(int pageNbr, int pageSize) {
        return honoraireRepos.findAll(PageRequest.of(pageNbr,pageSize)).map(HonoraireDto::mapToDTO);
    }

    @Override
    public HonoraireDto getHonoraire(long id) {
        Honoraire honoraire=honoraireRepos.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Honoraire not Found"));
        return HonoraireDto.mapToDTO(honoraire);
    }





}
