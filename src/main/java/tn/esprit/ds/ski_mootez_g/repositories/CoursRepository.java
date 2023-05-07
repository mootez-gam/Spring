package tn.esprit.ds.ski_mootez_g.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.ds.ski_mootez_g.entities.*;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {

    @Query(value = "SELECT * " +
            "FROM cours c " +
            "ORDER BY (SELECT COUNT * FROM inscription i WHERE i.cour_num_cours = c.num_cours)",nativeQuery = true)
    List<Cours> getAllOrderByInscriptionsNumberSQL();

    @Query(value = "SELECT c FROM Cours c ORDER BY c.inscriptions.size")
    List<Cours> getAllOrderByInscriptionsNumberJPQL();


    @Query(value= "SELECT c FROM Cours c WHERE c.typeCours=?1 AND c.support=?2 " )
    List<Cours>getcourbysupportskiettypecourcollectif_enfant(Support s , TypeCours t);
}
