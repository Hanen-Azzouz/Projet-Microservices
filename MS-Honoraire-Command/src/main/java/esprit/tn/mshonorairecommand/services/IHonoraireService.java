package esprit.tn.mshonorairecommand.services;

import esprit.tn.dto.HonoraireDto;

import java.util.Map;

public interface IHonoraireService {


    HonoraireDto add(HonoraireDto honoraireDto);
    HonoraireDto update(long idHonoraire, Map<Object,Object> fields);
    boolean delete(long idHonoraire);
}
