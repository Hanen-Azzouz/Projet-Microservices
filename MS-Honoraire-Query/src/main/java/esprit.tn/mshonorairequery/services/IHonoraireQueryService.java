package esprit.tn.mshonorairequery.services;


import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairequery.entities.Honoraire;
import org.springframework.data.domain.Page;

public interface IHonoraireQueryService {

Honoraire add(Honoraire honoraire);
Honoraire update(Honoraire honoraire);
boolean delete(long idHonoraire );
Page<HonoraireDto> getHonoraires(int pageNbr,int pageSize);
HonoraireDto getHonoraire(long id);


}
