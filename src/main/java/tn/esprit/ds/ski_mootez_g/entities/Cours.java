package tn.esprit.ds.ski_mootez_g.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long numCours;

    @Column
    private int niveau;

    @Enumerated(EnumType.STRING)
    private  TypeCours typeCours;

    @Enumerated(EnumType.ORDINAL)
    private Support support;

    private Float prix;

    private int creneau;

    @OneToMany(mappedBy = "cour")
    @JsonIgnore
    private Set<Inscription> inscriptions;
    /*,cascade = CascadeType.REMOVE :agregation)*/


}



/* GenerationType.IDENTITY : auto-increment par la base
 *  GenerationType.TABLE : auto-increment par hybernate*/