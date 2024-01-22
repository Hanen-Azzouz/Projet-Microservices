package esprit.tn.honoraireservice.repositories;

import esprit.tn.honoraireservice.entities.Honoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonoraireRepository extends JpaRepository<Honoraire,Long> {
}
