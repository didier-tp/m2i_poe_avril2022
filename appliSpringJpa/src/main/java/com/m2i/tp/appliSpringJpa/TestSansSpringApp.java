package com.m2i.tp.appliSpringJpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.m2i.tp.appliSpringJpa.dao.DaoEmployeJpaSansSpring;
import com.m2i.tp.appliSpringJpa.entity.Employe;

public class TestSansSpringApp {

	public static void main(String[] args) {
		// classe de démarrage de l'application (sans utiliser spring) 

		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("appliSpringJpa");
		//NB: appliSpringJpa configure dans META-INF/persistence.xml
		EntityManager entityManager = emf.createEntityManager();
		
		DaoEmployeJpaSansSpring daoEmployeJpa = new DaoEmployeJpaSansSpring();
		daoEmployeJpa.setEntityManager(entityManager);
		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		daoEmployeJpa.insertNew(emp1);
		
		List<Employe> employes = daoEmployeJpa.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		entityManager.close();
		emf.close();
	}

}
