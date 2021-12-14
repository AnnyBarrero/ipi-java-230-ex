package com.ipiecoles.java.java230.repository;
import com.ipiecoles.java.java230.model.Employe;
import org.springframework.stereotype.Repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;


public interface EmployeRepository extends JpaRepository<Employe, Long> {
    //    Recherche d'employés par matricule
    Employe findByMatricule(String matricule);
    //    Recherche d'employés par nom et prénom
    List<Employe> findByNomAndPrenom(String nom, String prenom);
    //    Recherche d'employés par nom sans prendre en compte la casse
    List<Employe> findByNomIgnoreCase(String nom);
    //    Recherche d'employés embauchés avant une certaine date
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);
    //    Recherche d'employés embauchés après une certaine date
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);
    //    Recherche d'employés gagnant plus de X euros et ordonnés selon leur salaire (ceux qui gagnent le plus d'abord).
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);


    //use pagination
    Page<Employe> findByNomIgnoreCase(String nom, Pageable pageable);

    @Query("select e from Employe e where lower(e.prenom) = lower(:nomOuPrenom) OR lower(e.nom) = lower(:nomOuPrenom)")
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);


    @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
    List<Employe> findEmployePlusRiches();
}