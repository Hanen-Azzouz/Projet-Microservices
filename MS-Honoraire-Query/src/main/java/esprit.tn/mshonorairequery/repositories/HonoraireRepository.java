package esprit.tn.mshonorairequery.repositories;


import esprit.tn.mshonorairequery.entities.Honoraire;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonoraireRepository extends MongoRepository<Honoraire,Long> {
}
