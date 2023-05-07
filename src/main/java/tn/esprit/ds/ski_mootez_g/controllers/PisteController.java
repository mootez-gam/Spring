package tn.esprit.ds.ski_mootez_g.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.ski_mootez_g.entities.Couleur;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Piste;
import tn.esprit.ds.ski_mootez_g.entities.Skieur;
import tn.esprit.ds.ski_mootez_g.services.IPisteService;

import javax.websocket.server.PathParam;
import java.util.List;
@RequestMapping("piste")
@RestController
public class PisteController {

    @Autowired
    IPisteService iPisteService;
    //localhost:9090/retrieveAllPistes
    @GetMapping
    public List<Piste> get_All()
    {
        return iPisteService.retrieveAllPistes();
    }
    //localhost:9090/addpiste
    @PostMapping
    public Piste add_piste(@RequestBody Piste piste)
    {
        return iPisteService.addpiste(piste);
    }

    @GetMapping("{numPiste}")
    Piste retrievePiste (@PathVariable Long numPiste)
    {
        return iPisteService.retrievePiste(numPiste);

    }
    @DeleteMapping("{numPiste}")
    void removePiste (@PathVariable Long numPiste)
    {
        iPisteService.removePiste(numPiste);
    }

    @PutMapping
    public Piste updatePiste(@RequestBody Piste piste)
    {
        return iPisteService.updatePiste(piste);
    }


    @GetMapping("getpistebycouleur/{couleur}")
    public List<Piste> getPisteByCouleur(@PathVariable Couleur couleur)
    {
        return iPisteService.getPisteByCouleur(couleur);
    }

}
