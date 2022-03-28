package com.m2i.tp.appliSpringJpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.appliSpringJpa.entity.Employe;

//CrudRepository<TypeEntite,TypeClefPrimaire> est une interface de DAO automatique
//predefinie dans Spring-data
//si option spring.data.jpa.repositories.enabled=true
//activée dans application.properties alors le framework génère automatiquement
//le code complet de la classe d'implémentation avec la technologie JPA
//----> plus qu'à tester/utiliser 

public interface DaoEmployeSpringData extends CrudRepository<Employe,Long>{
     //on hérite de findAll() , findById() , save()
}
