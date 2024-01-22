package esprit.tn.mshonorairequery.controllers;

import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairequery.services.IHonoraireQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/honorairemsquery")
@RequiredArgsConstructor
public class HonoraireQueryController {
    private  final IHonoraireQueryService honoraireRest;

    @GetMapping("{id}")
    public HonoraireDto getHonoraire(@PathVariable long id){
        return honoraireRest.getHonoraire(id);
    }
    @GetMapping
    public Page<HonoraireDto> getHonoraires(int pageNbr,int pageSize){
        return honoraireRest.getHonoraires(pageNbr,pageSize);
    }



}
