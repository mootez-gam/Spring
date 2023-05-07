package tn.esprit.ds.ski_mootez_g.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_mootez_g.entities.*;
import tn.esprit.ds.ski_mootez_g.services.ISkieurService;
import tn.esprit.ds.ski_mootez_g.services.ISkieurServiceImp;

import javax.persistence.PostRemove;
import javax.persistence.PreRemove;
import java.util.List;
@RequestMapping("skieur")
@RestController //indique que la classe est un controlleur et traite les requetes HTTP et renvoie les reponses HTTP
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> get_All()
    {
       return iSkieurService.retrieveAllSkieurs();
    }
    @GetMapping("{numSkieur}")
    Skieur retrieveSkieur (@PathVariable Long numSkieur)
    {
        return iSkieurService.retrieveSkieur(numSkieur);

    }
    //localhost:9090/addskieur
    @PostMapping
    public Skieur add_skieur(@RequestBody Skieur skieur)
    {
        return iSkieurService.addSkieur(skieur);
    }

    @DeleteMapping("{numSkieur}")
    void removeSkieur (@PathVariable Long numSkieur)
    {
        iSkieurService.removeSkieur(numSkieur);
    }
    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur skieur)
    {
        return iSkieurService.updateSkieur(skieur);
    }

    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste)
    {
        return iSkieurService.assignSkieurToPiste(numSkieur,numPiste);

    }
    @PutMapping("/AssignSkierToSubscription/{numSkieur}/{numAbon}")

    public Skieur AssignSkierToSubscription(@PathVariable long numSkieur, @PathVariable long numAbon) {

        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }

    @PutMapping("/AssignSkierToInscription/{numSkieur}/{numInscription}")

    public Skieur AssignSkierToInscription(@PathVariable long numSkieur, @PathVariable long numInscription) {

        return iSkieurService.assignSkierToInscription(numSkieur, numInscription);
    }


    @GetMapping("retrieveSkiersByAbonnmentType/{typeAbonnement}")
    public  List<Skieur> retrieveSkiersByAbonnmentType(@PathVariable TypeAbonnement typeAbonnement)
    {
       return  iSkieurService.retrieveSkiersByAbonnmentType(typeAbonnement);
    }
    @GetMapping("findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur/{inscriptions_cour_typeCours}/{inscriptions_cour_support}/{pistes_couleur}")
    public List<Skieur> findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(@PathVariable TypeCours inscriptions_cour_typeCours,@PathVariable Support inscriptions_cour_support,@PathVariable Couleur pistes_couleur)
    {

        return  iSkieurService.findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(inscriptions_cour_typeCours,inscriptions_cour_support,pistes_couleur);
    }

    @PostMapping("addSkierAndAssignToCourse")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur)
    {
        return iSkieurService.addSkierAndAssignToCourse(skieur);

    }

    @GetMapping("getskieurbyabonnement_typeabonnement_JPQL/{typeAbonnement}/{ville}")
    List<Skieur> getSkieurByAbonnement_TypeAbonJPQL(@PathVariable TypeAbonnement typeAbonnement ,@PathVariable String ville)
    {
        return iSkieurService.getSkieurByAbonnement_TypeAbonJPQL(typeAbonnement,ville);

    }


}
