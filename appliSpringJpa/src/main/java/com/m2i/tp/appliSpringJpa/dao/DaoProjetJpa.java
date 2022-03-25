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

//@Component //ou @Repository //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoProjetJpa implements DaoProjet{
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique 
	//entityManager à partir d'une configuration
	//  src/main/resources/META-INF/persistence.xml 
	//  ou bien config spring equivalente dans src/main/resources/application.properties
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Projet findById(Long code) {
		return entityManager.find(Projet.class, code); //SELECT .... WHERE code=...
	}

	

	@Override
	public Projet insertNew(Projet p) {
		//en entrée , emp est un nouvel objet employé avec .empId à null (encore inconnu)
		//déclenche automatiquement INSERT INTO Projet(firstname, ....) VALUES(emp.getFirstname() , ....)
		entityManager.persist(p);//.empId n'est normalement plus null si auto-incr
		return p; //on retourne l'objet modifié (avec .empId non null)
	}

	@Override
	public Projet update(Projet p) {
		return entityManager.merge(p);//déclenche automatiquement UPDATE Projet set .... WHERE code=code
	}

	@Override
	public void deleteById(long code) {
		Projet pAsupprimer = entityManager.find(Projet.class, code);
		entityManager.remove(pAsupprimer);//déclenche automatiquement DELETE FROM Projet WHERE code=code
	}
	
	@Override
	public List<Projet> findAll() {
		return entityManager.createQuery("SELECT p FROM Projet p",Projet.class)
				            .getResultList();
	}

	
	
}
