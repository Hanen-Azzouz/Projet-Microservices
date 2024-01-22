package esprit.tn.mshonorairecommand.repositories;

import esprit.tn.mshonorairecommand.entities.Honoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonoraireRepository extends JpaRepository<Honoraire,Long> {
}
