package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Projet;


/*
 * Cette version du DAO sera utilisé par Spring+JPA
 * et spring va initialiser automatiquement le entityManager
 * grace à l'annotation @PersistenceContext.
 * 
 * Spring va aussi déclencher automatiquement des commit/rollback
 * si on place @Transactional sur la classe ou une méthode
 */

@Component //ou @Repository //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoProjetJpa extends DaoJpa<Projet> implements DaoProjet{
	
	

	@Override
	public Projet findById(Long code) {
		return entityManager.find(Projet.class, code); //SELECT .... WHERE code=...
	}

	
	
	@Override
	public List<Projet> findAll() {
		return entityManager.createQuery("SELECT p FROM Projet p",Projet.class)
				            .getResultList();
	}

	
	
}
