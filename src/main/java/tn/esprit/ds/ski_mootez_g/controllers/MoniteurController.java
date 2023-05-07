package tn.esprit.ds.ski_mootez_g.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_mootez_g.entities.Moniteur;
import tn.esprit.ds.ski_mootez_g.services.IMoniteurService;

import java.util.List;
@RequestMapping("moniteur")
@RestController
public class MoniteurController {

    @Autowired
    IMoniteurService iMoniteurService;
    //localhost:9090/retrieveAllMoniteurs
    @GetMapping
    public List<Moniteur> get_All()
    {
        return iMoniteurService.retrieveAllMoniteur();
    }
    //localhost:9090/addMoniteur
    @PostMapping
    public Moniteur add_Moniteur(@RequestBody Moniteur Moniteur)
    {
        return iMoniteurService.addMoniteur(Moniteur);
    }

    @GetMapping("{numMoniteur}")
    Moniteur retrieveMoniteur (@PathVariable Long numMoniteur)
    {
        return iMoniteurService.retrieveMoniteur(numMoniteur);

    }
    @DeleteMapping("{numMoniteur}")
    void removeMoniteur (@PathVariable Long numMoniteur)
    {
        iMoniteurService.removeMoniteur(numMoniteur);
    }

    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur Moniteur)
    {
        return iMoniteurService.updateMoniteur(Moniteur);
    }

    @PutMapping("addInstructorAndAssignToCourse/{numCourse}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable Long numCourse)
    {
        return iMoniteurService.addInstructorAndAssignToCourse(moniteur,numCourse);
    }

}
