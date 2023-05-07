package tn.esprit.ds.ski_mootez_g.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.ds.ski_mootez_g.entities.*;

import java.util.List;

public interface SkieurRespository extends JpaRepository<Skieur,Long> {

    //@Query("select s from Skieur s where s.abonnement.typeAbon = ?1") //JPQL
    List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement); //Key word
    //la meme chose findSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

    @Query("select s from Skieur s where s.abonnement.typeAbon = ?1 and s.ville=?2") //JPQL
    List<Skieur> getSkieurByAbonnement_TypeAbonJPQL(TypeAbonnement typeAbonnement , String ville); //Key word

    @Query("select s from Skieur s where s.abonnement.typeAbon = :typeAbonnement and s.ville= :ville") //JPQL
    List<Skieur> getSkieurByAbonnement_TypeAbonJPQL2(@Param("typeAbonnement") TypeAbonnement typeAbonnement ,@Param("ville") String ville); //Key word

    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN abonnement a " +
            "ON s.abonnement_num_abon = a.num_abon " +
            "WHERE a.type_abon = :typeAbonnement "+
            "AND s.ville = :ville ",nativeQuery = true)//SQL
    List<Skieur> findByAbonnementTypeAbonAndVilleSQL(@Param("typeAbonnement") TypeAbonnement typeAbonnement, @Param("ville") String ville);
    List<Skieur> findByInscriptionsCourTypeCoursAndInscriptionsCourSupportAndPistesCouleur(TypeCours inscriptions_cour_typeCours, Support inscriptions_cour_support, Couleur pistes_couleur);


    @Query(value = "SELECT * FROM skieur s \n" +
            "JOIN inscription i \n" +
            "on s.num_skieur=i.skieur_num_skieur \n" +
            "JOIN cours c \n" +
            "on i.cour_num_cours=c.num_cours\n" +
            "JOIN moniteur_cours mc\n" +
            "on mc.moniteur_num_moniteur=c.num_cours\n" +
            "JOIN moniteur m \n" +
            "ON m.num_moniteur=mc.moniteur_num_moniteur\n" +
            "WHERE (c.support= :support) AND (m.nomm= :nom)"
            ,nativeQuery = true)
    List<Skieur> findSkieurbyMoniteurnameAndSupporttypeSQl(@Param("support") Support support, @Param("nom") String nom); //SQL

     @Query("select s from Skieur s " +
             "join Inscription i on i.skieur=s " +
             "join Moniteur m on i.cour member of  m.cours where m.nomM = :nom and i.cour.support = :support"
             ) //JPQL
     List<Skieur> findSkieurbyMoniteurnameAndSupporttypeJPQL(@Param("support") Support support, @Param("nom") String nom);





//NB: ki tibda lista bich ta3mel jointure femech list tit3ada direct

}
