package com.example.clinique.service;

import com.example.clinique.Exception.CliniqueException;
import com.example.clinique.dto.CliniqueDTO;
import com.example.clinique.entity.Clinique;

import java.util.List;

public interface CliniqueService {
    CliniqueDTO saveClinique(CliniqueDTO cliniqueDto);

    //APIResponseDto getEmployeeById(Long employeeId);

    List<CliniqueDTO> getAllClinique();
    void deleteClinique(Long id) throws CliniqueException;
    CliniqueDTO getClinique(Long cliniqueId) throws CliniqueException;

    public void updateClinique(Long id, Clinique clinique) throws CliniqueException;
}
