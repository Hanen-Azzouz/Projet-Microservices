package com.example.msmedicament.repositories;
import com.example.msmedicament.entities.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepo extends JpaRepository<Medicament,Long> {
}