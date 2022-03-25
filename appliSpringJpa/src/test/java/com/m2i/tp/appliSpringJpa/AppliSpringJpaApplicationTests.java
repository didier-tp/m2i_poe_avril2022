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
		//séquence de test idéale:
		//1. créer une nouvelle chose
		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		daoEmploye.insertNew(emp1);
		Long idEmp = emp1.getEmpId(); //clef primaire auto incrémentée du nouvel employé ajouté en base
		
		//2. afficher tout pour vérifier l'ajout
		List<Employe> employes = daoEmploye.findAll();
		for(Employe emp : employes) {
			System.out.println(emp);
		}
		
		//3. récupérer une entité précise via sa clef primaire et l'afficher
		Employe emp1Relu = daoEmploye.findById(idEmp);
		System.out.println("emp1Relu=" + emp1Relu);
		
		
		//4. modifier les valeurs en mémoire puis en base
		emp1Relu.setPhoneNumber("0504030201");
		daoEmploye.update(emp1Relu);
		
		//5. re-déclencher étape 3 pour vérifier la mise à jour en base
		Employe emp1Relu2 = daoEmploye.findById(idEmp);
		System.out.println("emp1Relu2 apres update =" + emp1Relu2);
		
		//6. supprimer la chose ajoutée à l'étape 1
		daoEmploye.deleteById(idEmp);
		
		//7. on vérifie que ça n'existe plus
		Employe emp1Relu3NormalementNull = daoEmploye.findById(idEmp);
		if(emp1Relu3NormalementNull==null)
			System.out.println("employe bien supprimé dans la base de données");
	     
	}

}
