package tn.esprit.ds.ski_mootez_g.services;

import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Inscription;

import java.util.List;

public interface IInscriptionService {


    Inscription addInscription(Inscription inscription);
    List<Inscription> retrieveAllInscription();

    void removeInscription (Long numInscription);
    Inscription retrieveInscription (Long numInscription);
    Inscription updateInscription(Inscription inscription);

    Inscription assignSkieurtoinscription(Long numskieur,Long numinscription);
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);

}
