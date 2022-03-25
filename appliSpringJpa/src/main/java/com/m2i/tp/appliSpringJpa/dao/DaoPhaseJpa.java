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

//@Component //ou @Repository //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoPhaseJpa implements DaoPhase{
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique 
	//entityManager à partir d'une configuration
	//  src/main/resources/META-INF/persistence.xml 
	//  ou bien config spring equivalente dans src/main/resources/application.properties
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Phase findById(Long code) {
		return entityManager.find(Phase.class, code); //SELECT .... WHERE code=...
	}

	

	@Override
	public Phase insertNew(Phase p) {
		//en entrée , emp est un nouvel objet employé avec .empId à null (encore inconnu)
		//déclenche automatiquement INSERT INTO Phase(firstname, ....) VALUES(emp.getFirstname() , ....)
		entityManager.persist(p);//.empId n'est normalement plus null si auto-incr
		return p; //on retourne l'objet modifié (avec .empId non null)
	}

	@Override
	public Phase update(Phase p) {
		return entityManager.merge(p);//déclenche automatiquement UPDATE Phase set .... WHERE code=code
	}

	@Override
	public void deleteById(long code) {
		Phase pAsupprimer = entityManager.find(Phase.class, code);
		entityManager.remove(pAsupprimer);//déclenche automatiquement DELETE FROM Phase WHERE code=code
	}
	
	@Override
	public List<Phase> findAll() {
		return entityManager.createQuery("SELECT p FROM Phase p",Phase.class)
				            .getResultList();
	}

	
	
}
