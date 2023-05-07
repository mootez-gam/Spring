package tn.esprit.ds.ski_mootez_g.services;

import tn.esprit.ds.ski_mootez_g.entities.Couleur;
import tn.esprit.ds.ski_mootez_g.entities.Cours;
import tn.esprit.ds.ski_mootez_g.entities.Piste;
import tn.esprit.ds.ski_mootez_g.entities.Skieur;

import java.util.List;

public interface IPisteService {

    List<Piste> retrieveAllPistes();
    Piste addpiste(Piste piste);
    void removePiste (Long numPiste);
    Piste retrievePiste (Long numPiste);
    Piste updatePiste(Piste piste);


    public List<Piste> getPisteByCouleur(Couleur couleur);

}
