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
public class DaoEmployeJpa implements DaoEmploye{
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique 
	//entityManager à partir d'une configuration
	//  src/main/resources/META-INF/persistence.xml 
	//  ou bien config spring equivalente dans src/main/resources/application.properties
	@PersistenceContext
	private EntityManager entityManager;

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
	public Employe insertNew(Employe emp) {
		//en entrée , emp est un nouvel objet employé avec .empId à null (encore inconnu)
		//déclenche automatiquement INSERT INTO Employe(firstname, ....) VALUES(emp.getFirstname() , ....)
		entityManager.persist(emp);//.empId n'est normalement plus null si auto-incr
		return emp; //on retourne l'objet modifié (avec .empId non null)
	}

	@Override
	public Employe update(Employe emp) {
		return entityManager.merge(emp);//déclenche automatiquement UPDATE Employe set .... WHERE idEmp=code
	}

	@Override
	public void deleteById(long code) {
		Employe empAsupprimer = entityManager.find(Employe.class, code);
		entityManager.remove(empAsupprimer);//déclenche automatiquement DELETE FROM Employe WHERE idEmp=code
	}

	
}
