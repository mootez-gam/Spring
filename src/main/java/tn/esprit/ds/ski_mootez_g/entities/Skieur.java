package tn.esprit.ds.ski_mootez_g.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaisance;
    private String ville;

    @OneToMany(mappedBy = "skieur")
    @JsonIgnore
    private List<Inscription> inscriptions;

    @ManyToMany
    private Set<Piste> pistes;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Abonnement abonnement;

}
