package tn.esprit.ds.ski_mootez_g.services;


import tn.esprit.ds.ski_mootez_g.entities.*;


import java.util.List;

public interface ICoursService {
    Cours addcours(Cours cours);
    List<Cours> retrieveAllCours();

    void removeCours (Long numCours);
    Cours retrieveCours (Long numCours);
    Cours updateCours(Cours cours);

    public void testschedule();

    List<Cours> getcourbysupportskiettypecourcollectif_enfant(Support s, TypeCours t);
}
