package com.m2i.tp.appliSpringJpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@SpringBootTest
class AppliSpringJpaApplicationTests {

		
	@Autowired //injection de dépendance via Spring
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmploye
	//dans ce projet , seule la classe DaoEmployeJpa correspond à ce critère
	private DaoEmploye daoEmploye;
	
	@Test 
	public void testAvecSpring() {
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		daoEmploye.insertNew(emp1);
		
		List<Employe> employes = daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
	}

}
