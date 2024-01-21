package com.example.msmedicament.restcontroller;
import com.example.msmedicament.dto.RecMedicamentDTO;
import com.example.msmedicament.services.IMedicamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Medicaments")
public class medicamentRestController {
    private  final IMedicamentService medicamentRest;

    @PostMapping("addMedicament")
    RecMedicamentDTO ajouterMedicament(@RequestBody RecMedicamentDTO medicamentDTO){

        return medicamentRest.addMedicament(medicamentDTO);
    }

    @PutMapping("updateMedicament")
    RecMedicamentDTO modifierMedicament(@RequestBody RecMedicamentDTO medicamentDTO){

        return medicamentRest.updateMedicament(medicamentDTO);
    }

    @DeleteMapping("deleteMedicament")
    void deleteMedicament(RecMedicamentDTO medicamentDTO){

        medicamentRest.deleteMedicament(medicamentDTO);
    }

    @DeleteMapping("deleteMedicamentById/{id}")
    void  deleteMedicamentById(@PathVariable long id){

        medicamentRest.deleteMedicament(id);
    }

    @GetMapping("findAllMedicaments/{size}/{pagenbr}")
    Page<RecMedicamentDTO> findAll(@PathVariable int size, @PathVariable int pagenbr){
        return medicamentRest.findAll(size,pagenbr);
    }

    @GetMapping("findOneMedicamentById/{id}")
    RecMedicamentDTO findById(@PathVariable long id){

        return medicamentRest.findById(id);
    }

}
