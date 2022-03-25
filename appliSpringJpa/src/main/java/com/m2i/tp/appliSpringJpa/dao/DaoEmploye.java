package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Employe;

/*
 * DaoEmploye = interface de DAO = Data Access Object
 * qui va permettre de déclencher des opérations CRUD
 * chaque méthode peut eventuellement remonter une exception 
 * héritant de RuntimeException (ex: JpaException)
 */

public interface DaoEmploye {
     Employe findById(Long code);
     List<Employe> findAll();
     List<Employe> findEmployeWithNameBeginBy(String debutNom);
     //...
     //Employe save(Employe emp); //dans springData au sens saveOrUpdate
     Employe insertNew(Employe emp); //en retour objet sauvegardé avec clef primaire connue (auto-incr)
     Employe update(Employe emp);
     
     void deleteById(long code); 
     //...
}
