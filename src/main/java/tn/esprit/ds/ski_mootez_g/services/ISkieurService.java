package tn.esprit.ds.ski_mootez_g.services;

import tn.esprit.ds.ski_mootez_g.entities.*;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);

    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur updateSkieur(Skieur skieur);

    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);
    Skieur assignSkierToInscription(Long numSkieur, Long numInscription);
    Skieur AssignSkierToSubscription(long numSkieur, long numAbon);
    Skieur addSkierAndAssignToCourse(Skieur skieur);

    List<Skieur> retrieveSkiersByAbonnmentType(TypeAbonnement typeAbonnement);

    List<Skieur> findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(TypeCours inscriptions_cour_typeCours, Support inscriptions_cour_support, Couleur pistes_couleur);

    List<Skieur> getSkieurByAbonnement_TypeAbonJPQL(TypeAbonnement typeAbonnement , String ville);

}
