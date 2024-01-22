package esprit.tn.mshonorairecommand.controllers;
import org.springframework.web.bind.annotation.*;
import esprit.tn.dto.HonoraireDto;
import esprit.tn.mshonorairecommand.services.IHonoraireService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/honorairemscommand")
@RequiredArgsConstructor

public class MsHonoraireController {
    private  final IHonoraireService honoraireRest;

    @PostMapping
    public HonoraireDto add(@RequestBody HonoraireDto honoraireDto){
        return honoraireRest.add(honoraireDto);
    }

    @PatchMapping("{id}")
    public HonoraireDto patchUpdate(@RequestBody Map<Object,Object> fields,@PathVariable long id){
        return honoraireRest.update(id,fields);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id){
        return honoraireRest.delete(id);
    }

}
