package tn.esprit.ds.ski_mootez_g.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_mootez_g.entities.*;
import tn.esprit.ds.ski_mootez_g.repositories.CoursRepository;

import java.util.List;
@Slf4j // pour faire l affichage de message d une fonction pas sur le console sur un fichier log
@Service
public class ICoursServiceImp implements ICoursService {

    @Autowired
    CoursRepository coursRepository;
    @Override
    public Cours addcours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public void removeCours(Long numCours) {
        log.info("in remove cour");
        coursRepository.deleteById(numCours);

    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElse(null);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Scheduled(fixedDelay = 60000) //1min -> 60000 em milli seconde
    @Scheduled(fixedRate = 60000)
    @Scheduled(cron ="0 0 0 * * MON-FRI" ) //seconde+minute+hour+day of mounth+mounth+day of week
    //For example, "0 * * * * MON-FRI" means once per minute on weekdays (at the top of the minute - the 0th second).
    //type de retour fonction Scheduled toujour void
    //et toujour sans parametre
    @Override
    public void testschedule() {
    log.info("waaaaaaaaaaa");
    //System.out.println();
    }

    @Override
    public List<Cours> getcourbysupportskiettypecourcollectif_enfant(Support s, TypeCours t) {
      return coursRepository.getcourbysupportskiettypecourcollectif_enfant(s, t);
    }


}
