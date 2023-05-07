package tn.esprit.ds.ski_mootez_g.services;

import tn.esprit.ds.ski_mootez_g.entities.Abonnement;
import tn.esprit.ds.ski_mootez_g.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface IAbonnementService {
    Abonnement addAbonnement(Abonnement abonnement);
    List<Abonnement> retrieveAllAbonnement();

    void removeAbonnement (Long numabonnement);
    Abonnement retrieveAbonnement (Long numabonnement);
    Abonnement updateAbonnement(Abonnement abonnement);
    List<Abonnement> trouverabonnementpartype(TypeAbonnement typeAbonnement);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
