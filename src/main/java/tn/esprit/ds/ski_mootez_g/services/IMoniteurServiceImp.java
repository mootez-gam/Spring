package tn.esprit.ds.ski_mootez_g.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Moniteur;
import tn.esprit.ds.ski_mootez_g.repositories.CoursRepository;
import tn.esprit.ds.ski_mootez_g.repositories.MoniteurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IMoniteurServiceImp implements IMoniteurService{
    @Autowired
    MoniteurRepository moniteurRepository;
    @Autowired
  CoursRepository coursRepository;
    @Override
    public Moniteur addMoniteur(Moniteur Moniteur) {
        return moniteurRepository.save(Moniteur);
    }

    @Override
    public List<Moniteur> retrieveAllMoniteur() {
        return moniteurRepository.findAll();
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
    moniteurRepository.deleteById(numMoniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElse(null);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur Moniteur) {
        return moniteurRepository.save(Moniteur);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Optional<Cours> cours = coursRepository.findById(numCourse);
        if (cours==null) {
            throw new IllegalArgumentException("Course with id " + numCourse + " not found.");
        }
        Cours courss = cours.get();
        moniteur.getCours().add(courss);
        return moniteurRepository.save(moniteur);
    }
}
