package tn.esprit.ds.ski_mootez_g.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ds.ski_mootez_g.entities.Couleur;
import tn.esprit.ds.ski_mootez_g.entities.Piste;

import java.util.List;

public interface PisteRepository extends JpaRepository<Piste,Long> {


    public List<Piste> getPisteByCouleur(Couleur couleur);
}
