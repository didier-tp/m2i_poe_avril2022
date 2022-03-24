package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Employe;

/*
 * DaoEmploye = interface de DAO = Data Access Object
 * qui va permettre de déclencher des opérations CRUD
 */

public interface DaoEmploye {
     Employe findById(Long code);
     List<Employe> findAll();
     //...
     //Employe save(Employe emp); //dans springData au sens saveOrUpdate
     Employe insertNew(Employe emp); //en retour objet sauvegardé avec clef primaire connue (auto-incr)
     Employe update(Employe emp);
     
     void deleteById(long code);
}
