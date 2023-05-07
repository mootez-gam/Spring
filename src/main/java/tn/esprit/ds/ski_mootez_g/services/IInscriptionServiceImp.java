package tn.esprit.ds.ski_mootez_g.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Inscription;
import tn.esprit.ds.ski_mootez_g.entities.Skieur;
import tn.esprit.ds.ski_mootez_g.repositories.CoursRepository;
import tn.esprit.ds.ski_mootez_g.repositories.InscriptionRepository;
import tn.esprit.ds.ski_mootez_g.repositories.SkieurRespository;

import java.util.List;
import java.util.Set;

@Service
public class IInscriptionServiceImp implements IInscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    SkieurRespository skieurRespository;
    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);    }

    @Override
    public List<Inscription> retrieveAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public void removeInscription(Long numInscription) {
    inscriptionRepository.deleteById(numInscription);
    }

    @Override
    public Inscription retrieveInscription(Long numInscription) {
        return inscriptionRepository.findById(numInscription).orElse(null);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignSkieurtoinscription(Long numskieur, Long numinscription) {
        Inscription inscription = inscriptionRepository.findById(numinscription).orElse(null);
        Skieur skieur = skieurRespository.findById(numskieur).orElse(null);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }


    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.findById(numRegistration).orElse(null);
        Cours cours = coursRepository.findById(numCourse).orElse(null);

        if(inscription != null && cours !=null)
        {
            Set<Inscription> inscriptions = cours.getInscriptions();
            inscriptions.add(inscription);
            cours.setInscriptions(inscriptions);
            coursRepository.save(cours);
        }
return null;
    }
}
