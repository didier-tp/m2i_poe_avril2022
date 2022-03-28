package com.m2i.tp.appliSpringJpa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.dao.DaoPhase;
import com.m2i.tp.appliSpringJpa.dao.DaoProjet;
import com.m2i.tp.appliSpringJpa.entity.Employe;
import com.m2i.tp.appliSpringJpa.entity.Phase;
import com.m2i.tp.appliSpringJpa.entity.Projet;

@SpringBootTest
class TestProjetEtPhase {

		
	@Autowired 
	private DaoProjet daoProjet;
	
	@Autowired 
	private DaoPhase daoPhase;
	
	@Autowired 
	private DaoEmploye daoEmploye;
	
	public static Date dateFromString(String sDate) {
		Date d=null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d=df.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	@Test 
	public void test1() {
		//créer 2 nouveaux projets et les inserer en base
		Projet projetA  = new Projet(null,"projetA","projet A qui va bien" ,
				          dateFromString("2022-03-27"),dateFromString("2023-03-27"),20000.0);
		Projet projetB  = new Projet(null,"projetB","projet B qui va bien" ,
				          dateFromString("2022-04-15"),dateFromString("2023-04-15"),30000.0);
		daoProjet.insertNew(projetA); daoProjet.insertNew(projetB);
		
		//créer 4 nouvelles phases et les inserer en base
		//2phases attachées au premier projet et 2phases pour le second
		Phase phase_a1  = new Phase(null,"phase_a1","phase 1 du projet A" ,
				                    dateFromString("2022-03-28"),dateFromString("2022-09-28"),null,
				                    0.5,projetA);
		daoPhase.insertNew(phase_a1);
		Phase phase_a2  = new Phase(null,"phase_a2","phase 2 du projet A" ,
                dateFromString("2022-09-29"),dateFromString("2023-03-27"),null,
                0.5,projetA);
        daoPhase.insertNew(phase_a2);
        Phase phase_b1  = new Phase(null,"phase_b1","phase 1 du projet B" ,
                dateFromString("2022-04-15"),dateFromString("2022-10-14"),null,
                0.5,projetB);
		daoPhase.insertNew(phase_b1);
		Phase phase_b2  = new Phase(null,"phase_b2","phase 2 du projet B" ,
		dateFromString("2022-10-15"),dateFromString("2023-04-15"),null,
		0.5,projetB);
		daoPhase.insertNew(phase_b2);
		
		//on récupère et on affiche toutes les phases du projet 1
		for(Phase p : daoPhase.findPhasesByProject(projetA.getCode())) {
			System.out.println(p);
		}
		
		//...
		//Projet projetBrelu = daoProjet.findById(projetB.getCode());
		Projet projetBrelu = daoProjet.findProjectWithPhases(projetB.getCode());
		System.out.println("projetBrelu="+projetBrelu.toString());
		//Attention : les phases reliées au projet via @OneToMany
		//ne sont toujours remontées en mémoire (en mode lazy)
		//Potentielle exception (lazyInitializationException)
		for(Phase p : projetBrelu.getPhases()) {
			System.out.println("\t" + p);
		}
		
		daoProjet.deleteById(projetB.getCode());//avec suppression des phases en cascade
		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login1","pwd1");
		daoEmploye.insertNew(emp1);
		phase_a1.addEmploye(emp1);
		
		Employe emp2 = new Employe(null,"prenom2","Nom2","0102030405","p.n@xyz.com","login2","pwd2");
		daoEmploye.insertNew(emp2);
		phase_a1.addEmploye(emp2);
		
		daoPhase.update(phase_a1);//sauvegarder en base le lien entre phase_a1 et les employés ajoutés
		
        List<Employe> employesPhase_a1 = daoPhase.findEmployesOfPhase(phase_a1.getCode());
        System.out.println("employesPhase_a1="+employesPhase_a1);
		
	}
	

}
