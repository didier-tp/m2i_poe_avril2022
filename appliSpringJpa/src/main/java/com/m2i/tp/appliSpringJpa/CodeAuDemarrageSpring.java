package com.m2i.tp.appliSpringJpa;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@Component
public class CodeAuDemarrageSpring {
	
	@Autowired //injection de dépendance via Spring
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmploye
	//dans ce projet , seule la classe DaoEmployeJpa correspond à ce critère
	private DaoEmploye daoEmploye;
	
	@PostConstruct //appelé automatiquement après la prise en compte de @Autowired
	public void testAvecSpring() {
		//Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		//daoEmploye.insertNew(emp1);
		
		List<Employe> employes = daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
	}

}
