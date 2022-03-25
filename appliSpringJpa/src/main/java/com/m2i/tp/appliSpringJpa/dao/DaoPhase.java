package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Phase;

/*
 * DaoPhase = interface de DAO = Data Access Object
 * qui va permettre de déclencher des opérations CRUD
 * chaque méthode peut eventuellement remonter une exception 
 * héritant de RuntimeException (ex: JpaException)
 */

public interface DaoPhase extends Dao<Phase>{
    
     List<Phase> findPhasesByProject(Long codeProjet);
}
