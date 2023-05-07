package tn.esprit.ds.ski_mootez_g.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Testentity {
    @Id
    private Long id;
}


 //  bich tasne3 repo direct mta3 class tisata3mel Spring data repository w tal9aha mil fou9 bil vert w lazem esm il class 7adher