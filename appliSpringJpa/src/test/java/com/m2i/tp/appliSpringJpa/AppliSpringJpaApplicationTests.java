package com.m2i.tp.appliSpringJpa;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Adresse;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@SpringBootTest
class AppliSpringJpaApplicationTests {

		
	@Autowired //injection de dépendance via Spring
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmploye
	//dans ce projet , seule la classe DaoEmployeJpa correspond à ce critère
	private DaoEmploye daoEmploye;
	
	private static Validator validator;  //initialized by @BeforeAll
	
	@BeforeAll
	protected static void initValidator(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	
	@Test 
	public void testFindEmployeWithNameBeginBy() {
		System.out.println("Liste des employes dont le nom commence par A :");
		List<Employe> employes = daoEmploye.findEmployeWithNameBeginBy("A");
		for(Employe emp : employes) {
			System.out.println("\t" +emp);
		}
	}
	
	protected <T> void validateEntity(T entity) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity);
		for (ConstraintViolation<T> violation : violations) {
		    //log.error("*** validation error: " + violation.getMessage()); 
			System.err.println("*** validation error: " + violation.getMessage()); 
		}
	}
	
	protected <T> void validateEntityThrowingException(T entity) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity);
		StringBuilder sb = new StringBuilder();
		for (ConstraintViolation<T> violation : violations) {
		    //log.error("*** validation error: " + violation.getMessage()); 
			System.err.println("*** validation error: " + violation.getMessage()); 
			sb.append(violation.getMessage()+ " ; ");
		}
		if(violations.size()>0)
			throw new RuntimeException("entity is not valid: " + sb.toString());
	}
	
	@Test 
	public void testAvecSpring() {
		//séquence de test idéale:
		//1. créer une nouvelle chose
		
		Employe invalidEmp1 = new Employe(null,null,null,"0102030405","jean.BonSansArobasxyz.com","login","p");
		validateEntity(invalidEmp1);
		//validateEntityThrowingException(invalidEmp1);
		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		Adresse adr1 = new Adresse(null,"12 rue Elle","75001","Par ici");
		emp1.setAdressePrincipale(adr1);
		
		validateEntity(emp1);
		
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
		System.out.println("avec adresse=" + emp1Relu.getAdressePrincipale());
		
		
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
