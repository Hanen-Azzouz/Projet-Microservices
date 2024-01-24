package com.microserviceambulance.Ambulance.repository;

import java.util.List;
import java.util.Optional;

import com.microserviceambulance.Ambulance.model.Ambulance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface AmbulanceRepository extends MongoRepository<Ambulance, String> {

    @Query("{'matricule': ?0}")
    Optional<Ambulance> findByMatricule(String matricule);

    @Query("{'idClinique': ?0}")
    List<Ambulance> findByClinique(int idClinique);

}

