package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Employe;


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
public class DaoEmployeJpa extends DaoJpa<Employe> implements DaoEmploye{
	
	
	@Override
	public Employe findById(Long code) {
		return entityManager.find(Employe.class, code); //SELECT .... WHERE empId=...
	}

	
	@Override
	public List<Employe> findAll() {
		return entityManager.createQuery("SELECT e FROM Employe e",Employe.class)
				            .getResultList();
	}

	@Override
	public List<Employe> findEmployeWithNameBeginBy(String debutNom) {
		/*
		return entityManager.createQuery("SELECT e FROM Employe e WHERE e.lastname LIKE :debut",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
		*/
		return entityManager.createNamedQuery("Employe.findEmployeWithNameBeginBy",Employe.class)
	            .setParameter("debut", debutNom+"%")
				.getResultList();
	}

	
}
