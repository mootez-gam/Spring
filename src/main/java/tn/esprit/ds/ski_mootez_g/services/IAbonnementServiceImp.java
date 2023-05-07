package tn.esprit.ds.ski_mootez_g.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_mootez_g.entities.Abonnement;
import tn.esprit.ds.ski_mootez_g.entities.TypeAbonnement;
import tn.esprit.ds.ski_mootez_g.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class IAbonnementServiceImp implements IAbonnementService {
    @Autowired
    AbonnementRepository abonnementRepository;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement) ;
    }

    @Override
    public List<Abonnement> retrieveAllAbonnement() {
        return abonnementRepository.findAll();
    }

    @Override
    public void removeAbonnement(Long numabonnement) {
    abonnementRepository.deleteById(numabonnement);
    }

    @Override
    public Abonnement retrieveAbonnement(Long numabonnement) {
        return abonnementRepository.findById(numabonnement).orElse(null);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement) ;
    }
    @Override
    public List<Abonnement> trouverabonnementpartype(TypeAbonnement typeAbonnement)
    {
     return abonnementRepository.findByTypeAbon(typeAbonnement);
    }
    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate)
    {
        return abonnementRepository.getAbonnementsByDateDebutAfterAndDateFinBefore(startDate,endDate);

    }
}
