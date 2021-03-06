package com.m2i.tp.appliSpringJpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


/*
 * DAO JPA générique (partiel)
 */


@Transactional //pour commit/rollback automatique
public abstract class DaoJpa<T> implements Dao<T>{
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique 
	//entityManager à partir d'une configuration
	//  src/main/resources/META-INF/persistence.xml 
	//  ou bien config spring equivalente dans src/main/resources/application.properties
	@PersistenceContext
	protected EntityManager entityManager;



	@Override
	public T insertNew(T p) {
		entityManager.persist(p);
		return p; 
	}

	@Override
	public T update(T p) {
		return entityManager.merge(p);//déclenche automatiquement UPDATE T set .... WHERE code=code
	}

	@Override
	public void deleteById(long code) {
		T pAsupprimer = this.findById(code);
		entityManager.remove(pAsupprimer);//déclenche automatiquement DELETE FROM T WHERE code=code
	}
	
	
}
