package tn.esprit.ds.ski_mootez_g.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement  {  /*extends BaseEntity*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long numAbon;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbon;
    private TypeAbonnement typeAbon;
    /*@OneToOne
    private Skieur skieur;*/
}
