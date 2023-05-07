package tn.esprit.ds.ski_mootez_g.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.ski_mootez_g.entities.Abonnement;
import tn.esprit.ds.ski_mootez_g.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    List<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    List<Abonnement> getAbonnementsByDateDebutAfterAndDateFinBefore(LocalDate startdate,LocalDate enddate);
}
