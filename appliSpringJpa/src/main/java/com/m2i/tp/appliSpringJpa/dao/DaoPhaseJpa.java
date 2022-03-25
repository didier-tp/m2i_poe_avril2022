package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Phase;


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
public class DaoPhaseJpa extends DaoJpa<Phase> implements DaoPhase{
	

	@Override
	public Phase findById(Long code) {
		return entityManager.find(Phase.class, code); //SELECT .... WHERE code=...
	}

	
	@Override
	public List<Phase> findAll() {
		return entityManager.createQuery("SELECT p FROM Phase p",Phase.class)
				            .getResultList();
	}


	@Override
	public List<Phase> findPhasesByProject(Long codeProjet) {
		return entityManager.createQuery("SELECT p FROM Phase p WHERE p.projet.code = :codeP",Phase.class)
	            .setParameter("codeP", codeProjet)
	            .getResultList();
	}

	
}
