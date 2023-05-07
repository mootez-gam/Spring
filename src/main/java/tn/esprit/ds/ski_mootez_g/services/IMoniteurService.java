package tn.esprit.ds.ski_mootez_g.services;

import tn.esprit.ds.ski_mootez_g.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {
    Moniteur addMoniteur(Moniteur Moniteur);

    List<Moniteur> retrieveAllMoniteur();

    void removeMoniteur(Long numMoniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);

    Moniteur updateMoniteur(Moniteur Moniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
}
