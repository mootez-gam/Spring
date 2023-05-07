package tn.esprit.ds.ski_mootez_g.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ds.ski_mootez_g.entities.*;
import tn.esprit.ds.ski_mootez_g.repositories.*;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ISkieurServiceImp  implements ISkieurService{

    private final SkieurRespository skieurRespository ;

    private final PisteRepository pisteRepository;

    private final AbonnementRepository abonnementRepository;

    private final InscriptionRepository inscriptionRepository;
    private final CoursRepository coursRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRespository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRespository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRespository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur)
    {
        return skieurRespository.findById(numSkieur).orElse(null);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur)
    {
        return skieurRespository.save(skieur);
    }

    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur = skieurRespository.findById(numSkieur).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
       if(skieur != null && piste != null )
       {
          // skieur.getPistes().add(piste);
           Set<Piste> pistes = skieur.getPistes();
           pistes.add(piste);
           skieur.setPistes(pistes);
           skieurRespository.save(skieur);
       }
       return  null;
    }
    @Override
    public Skieur AssignSkierToSubscription(long numSkieur, long numAbon) {
        //RECUPERATION ID
        Skieur skieur=skieurRespository.findById(numSkieur).orElse(null) ;
        Abonnement abonnement=abonnementRepository.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement n existe pas ");
        //verrificationnon null
        //if(skieur!=null && abonnement!=null){
            //traitement
            // skieur.getPistes().add(piste);

            skieur.setAbonnement(abonnement);
            return  skieurRespository.save(skieur);
        //}
        //return null;
    }

    @Override
    public Skieur assignSkierToInscription(Long numSkieur, Long numInscription) {
        Skieur skieur=skieurRespository.findById(numSkieur).orElse(null) ;
        Inscription inscription=inscriptionRepository.findById(numInscription).orElse(null);
        //verrificationnon null
        if(skieur!=null && inscription!=null){
        //traitement
            // skieur.getPistes().add(piste);
            List<Inscription>inscriptions=skieur.getInscriptions();
            inscriptions.add(inscription);
            skieur.setInscriptions(inscriptions);
            return  skieurRespository.save(skieur);

        }
        return null;    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {//add event and assegn to participant
        Assert.notNull(skieur.getAbonnement(),"abonnement must not be empty");
        Assert.notNull(skieur.getInscriptions(),"inscription must not be empty");
        List<Inscription> inscriptions = skieur.getInscriptions();
        inscriptions.forEach(inscription -> {
            Assert.notNull(inscription.getCour().getNumCours(),"Cours must be entred");
            Cours cours = coursRepository.findById(inscription.getCour().getNumCours()).orElse(null);
            Assert.notNull(cours,"no cour found with this id ");
            inscription.setCour(cours);
           /* skieurRespository.saveAndFlush(skieur);*/
            inscription.setSkieur(skieur);
            inscriptionRepository.save(inscription);
            //exeption hander
        });
        skieurRespository.save(skieur);//ajouter l objet skieur a la base
       /* skieur.getInscriptions().forEach(inscription -> {
            inscription.setSkieur(skieur); //affecter l objet skieur a l inscription
            inscriptionRepository.save(inscription);
        });*/
        return skieur;
    }

    /*@Override
    public Integer ajouterAssurance(Assurance a, Integer cinBf) {
        Beneficiaire bf =beneficiaireReposotory.findBeneficiaireByCinEquals(cinBf);
        Contrat c=a.getContrat();
        Assert.notNull(bf,"banque n'existe pas");
        if(bf!=null&& c!=null){
            contratReposotory.save(c);
            List<Assurance> ah=bf.getAssurances();
            ah.add(a);
            bf.setAssurances(ah);
            beneficiaireReposotory.save(bf);
            a.setBeneficiaire(bf);
            assuranceReposotory.save(a);
            return a.getBeneficiaire().getCin();
        }
        return 0;
    }*/


    //Nested JSON Object

    public List<Skieur> retrieveSkiersByAbonnmentType(TypeAbonnement typeAbonnement)
    {
       return skieurRespository.getSkieurByAbonnement_TypeAbon(typeAbonnement);
    }

    @Override
    public List<Skieur> findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(TypeCours inscriptions_cour_typeCours, Support inscriptions_cour_support, Couleur pistes_couleur) {
        return  skieurRespository.findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(inscriptions_cour_typeCours,inscriptions_cour_support,pistes_couleur);
    }

    @Override
    public List<Skieur> getSkieurByAbonnement_TypeAbonJPQL(TypeAbonnement typeAbonnement, String ville) {
        return skieurRespository.getSkieurByAbonnement_TypeAbonJPQL(typeAbonnement,ville);
    }


}
