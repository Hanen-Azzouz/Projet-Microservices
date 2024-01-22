package esprit.tn.honoraireservice.restcontrollers;

import esprit.tn.honoraireservice.dto.HonoraireDTO;
import esprit.tn.honoraireservice.services.IHonoraireService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@RequestMapping("Honoraire")
@RestController
@RequiredArgsConstructor

public class HonoraireRestController {

    public  final IHonoraireService honoraireRest;
    @PostMapping("/addHonoraire")
    HonoraireDTO ajouterHonoraire(@RequestBody HonoraireDTO honoraireDTO){

        return honoraireRest.addHonoraire(honoraireDTO);
    }
    @PutMapping("/updateHonoraire")
    HonoraireDTO modifierHonoraire(@RequestBody HonoraireDTO honoraireDTO) {
        return honoraireRest.updateHonoraire(honoraireDTO);
    }
    @GetMapping("/findAllHonoraires/{size}/{pagenbr}")
    Page<HonoraireDTO> findAll(@PathVariable int size,@PathVariable int pagenbr){
        return honoraireRest.findAll(size,pagenbr);

    }
    @GetMapping("/findOneHonoraireById/{id}")
    HonoraireDTO findOneHonoraire(@PathVariable long id){
        return honoraireRest.findById(id);
    }
    @DeleteMapping("/deleteHonoraireById/{id}")
    void deleteHonoraireById(@PathVariable long id){
        honoraireRest.deleteHonoraire(id);
    }
    @DeleteMapping("/deleteHonoraire")
    void deleteHonoraire(@RequestBody HonoraireDTO honoraireDTO){

        honoraireRest.deleteHonoraire(honoraireDTO);
    }






}
