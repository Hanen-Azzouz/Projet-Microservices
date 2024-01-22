package com.example.msdepot.repositories;
import com.example.msdepot.entities.Depot;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DepotRepo extends MongoRepository<Depot,String> {
}
