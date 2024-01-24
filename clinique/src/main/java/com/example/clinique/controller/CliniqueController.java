package com.example.clinique.controller;

import com.example.clinique.Exception.CliniqueException;
import com.example.clinique.dto.CliniqueDTO;
import com.example.clinique.entity.Clinique;
import com.example.clinique.service.CliniqueService;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clinique")
@AllArgsConstructor
@CrossOrigin("*")
public class CliniqueController {

    private CliniqueService cliniqueService;

    // Build Save Employee REST API
    @PostMapping
    public ResponseEntity<CliniqueDTO> saveClinique(@RequestBody CliniqueDTO cliniqueDTO){
        CliniqueDTO savedClinique = cliniqueService.saveClinique(cliniqueDTO);
        return new ResponseEntity<>(savedClinique, HttpStatus.CREATED);
    }

/*

   // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<CliniqueDTO> getClinique(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto = cliniqueService.getClinique(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }*/

    @GetMapping("")
    public ResponseEntity<?> getAllClinique() {
        List<CliniqueDTO> cliniques = cliniqueService.getAllClinique();
        return new ResponseEntity<>(cliniques, cliniques.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<?> getClinique(@PathVariable("id") Long id) throws CliniqueException{
        try {
            System.out.println("behi");
            return new ResponseEntity<>(cliniqueService.getClinique(id), HttpStatus.OK);
        } catch (CliniqueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) throws CliniqueException{
        try{
            cliniqueService.deleteClinique(id);
            return new ResponseEntity<>("Successfully deleted ambulance with id "+id, HttpStatus.OK);
        }
        catch (CliniqueException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") Long id, @RequestBody Clinique clinique)
    {
        try {
            cliniqueService.updateClinique(id,clinique);
            return new ResponseEntity<>("Updated clinique with id "+id+"", HttpStatus.OK);
        }
        catch(ConstraintViolationException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (CliniqueException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
