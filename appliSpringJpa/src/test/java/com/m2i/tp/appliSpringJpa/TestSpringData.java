package com.m2i.tp.appliSpringJpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.entity.Employe;
import com.m2i.tp.appliSpringJpa.repository.DaoEmployeSpringData;

@SpringBootTest
class TestSpringData {

		
	@Autowired //injection de dépendance via Spring
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmployeDaoEmployeSpringData
	private DaoEmployeSpringData daoEmploye;
	
	
	
	
	@Test 
	public void testAvecSpring() {

		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		daoEmploye.save(emp1);
		
		Employe emp2 = new Employe(null,"prenom2","Nom2","0102030405","jean.Bon@xyz.com","login","pwd");
		daoEmploye.save(emp2);

		

		List<Employe> employes = (List<Employe>)daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
	     
	}

}
