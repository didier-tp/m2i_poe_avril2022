package com.m2i.tp.appliSpringJpa.dao;

import com.m2i.tp.appliSpringJpa.entity.Projet;

/*
 * DaoProjet = interface de DAO = Data Access Object
 * qui va permettre de déclencher des opérations CRUD
 * chaque méthode peut eventuellement remonter une exception 
 * héritant de RuntimeException (ex: JpaException)
 */

public interface DaoProjet extends Dao<Projet> {
      
     //... futurs méthodes de recherche spécifiques au DaoProjet
	Projet findProjectWithPhases(Long codeProjet);
}
