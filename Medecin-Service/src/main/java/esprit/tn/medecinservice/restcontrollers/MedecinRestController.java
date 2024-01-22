package esprit.tn.medecinservice.restcontrollers;

import esprit.tn.medecinservice.dto.MedecinDTO;
import esprit.tn.medecinservice.services.IMedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Medecin")
public class MedecinRestController {

    private final IMedecinService medecinRest;
    @PostMapping("/addMedecin")
    MedecinDTO ajouterMedecin(@RequestBody MedecinDTO medecinDTO){
        return medecinRest.addMedecin(medecinDTO);
    }
    @PutMapping("/updateMedecin")
    MedecinDTO modifierMedecin(@RequestBody MedecinDTO medecinDTO){

        return medecinRest.updateMedecin(medecinDTO);
    }
    @GetMapping("/findAllMedecins/{size}/{pagenbr}")
    Page<MedecinDTO> findAllMedecins(@PathVariable int size, @PathVariable int pagenbr){
        return medecinRest.findAll(size,pagenbr);
    }

    @GetMapping("/findOneMedecinById/{id}")
    MedecinDTO findOneMedecinById(@PathVariable long id){
        return  medecinRest.findById(id);
    }
    @DeleteMapping("/deleteMedecinById/{id}")
    void deleteMedecinById(@PathVariable long id){
        medecinRest.deleteMedecinById(id);
    }
    @DeleteMapping("/deleteMedecin")
    void deleteMedecin(@RequestBody MedecinDTO medecinDTO){
        medecinRest.deleteMedecin(medecinDTO);
    }


}
