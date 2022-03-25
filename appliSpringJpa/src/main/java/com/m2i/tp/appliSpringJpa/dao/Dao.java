package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

//version générique d'un DAO
//où T sera remplacée par Projet ou Phase ou ...

public interface Dao<T> {
	 T findById(Long id);
     List<T> findAll();
     //...
  
     T insertNew(T p); //en retour objet sauvegardé avec clef primaire connue (auto-incr)
     T update(T p);
     
     void deleteById(long code); 
     //...
}
