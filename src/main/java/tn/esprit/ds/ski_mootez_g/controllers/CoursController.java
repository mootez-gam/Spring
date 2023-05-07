package tn.esprit.ds.ski_mootez_g.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Piste;
import tn.esprit.ds.ski_mootez_g.services.ICoursService;

import java.util.List;
@RequestMapping("cours")
@RestController
public class CoursController {
    @Autowired
    ICoursService iCoursService;
    //localhost:9090/retrieveAllCours
    @GetMapping
    public List<Cours> get_All()
    {
        return iCoursService.retrieveAllCours();
    }
    //localhost:9090/addcours
    @PostMapping
    public Cours add_cour(@RequestBody Cours cours)
    {
        return iCoursService.addcours(cours);
    }

    @GetMapping("{numCours}")
    Cours retrieveCours (@PathVariable Long numCours)
    {
        return iCoursService.retrieveCours(numCours);

    }
    @DeleteMapping("{numCours}")
    void removeCours (@PathVariable Long numCours)
    {
        iCoursService.removeCours(numCours);
    }
    @PutMapping
    public Cours updateCours(@RequestBody Cours cours)
    {
        return iCoursService.updateCours(cours);
    }
}
