package esprit.tn.honoraireservice.services;

import esprit.tn.honoraireservice.dto.MedecinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="MEDECIN-MS")
public interface FeignMedecinService {
    @GetMapping("Medecin/findOneMedecinById/{id}")
    MedecinDTO findMedecinById(@PathVariable long id);
    @PostMapping("Medecin/addMedecin")
    MedecinDTO ajouterMedecin(@RequestBody MedecinDTO medecinDTO);

}
