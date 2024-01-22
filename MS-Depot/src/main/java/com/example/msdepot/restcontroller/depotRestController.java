package com.example.msdepot.restcontroller;
import com.example.msdepot.dto.RecDepotDTO;
import com.example.msdepot.services.IDepotService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Depots")
public class depotRestController {
    private final IDepotService depotRest;

    @PostMapping("addDepot")
    RecDepotDTO ajouterDepot(@RequestBody RecDepotDTO depotDTO){
        return depotRest.addDepot(depotDTO);
    }

    @PutMapping("updateDepot")
    RecDepotDTO modifierDepot(@RequestBody RecDepotDTO depotDTO){
        return depotRest.updateDepot(depotDTO);
    }


    @DeleteMapping("deleteDepotById/{id}")
    void deleteDepotById(@PathVariable @ApiParam(value = "ID de Depot", required = true) String id){
        depotRest.deleteDepot(id);
    }

    @DeleteMapping("deleteStock")
    void deleteDepot(RecDepotDTO depotDTO){
        depotRest.deleteDepot(depotDTO);
    }
    @GetMapping("findAllDepots/{size}/{pagenbr}")
    Page<RecDepotDTO> findAll(@PathVariable int size, @PathVariable int pagenbr){
        return depotRest.findAll(size,pagenbr);
    }
    @GetMapping("findOneDepotById/{id}")
    RecDepotDTO findById(@PathVariable @ApiParam(value = "ID de depot", required = true) String id){
        return depotRest.findById(id);
    }

}