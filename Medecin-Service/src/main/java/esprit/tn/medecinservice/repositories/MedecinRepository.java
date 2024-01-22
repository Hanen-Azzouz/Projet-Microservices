package esprit.tn.medecinservice.repositories;

import esprit.tn.medecinservice.entities.Medecin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends MongoRepository<Medecin,Long> {
    Medecin findByNomMedecin(long id);
}
