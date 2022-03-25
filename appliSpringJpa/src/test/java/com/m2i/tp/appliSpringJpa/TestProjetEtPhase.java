package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoPhase;
import com.m2i.tp.appliSpringJpa.dao.DaoProjet;

@SpringBootTest
class TestProjetEtPhase {

		
	@Autowired 
	private DaoProjet daoProjet;
	
	@Autowired 
	private DaoPhase daoPhase;
	
	
	@Test 
	public void test1() {
		//créer 2 nouveaux projets et les inserer en base
		
		
		//créer 4 nouvelles phases et les inserer en base
		//2phases attachées au premier projet et 2phases pour le second
		
		//on récupère et on affiche toutes les phases du projet 1
		
		//...
		
	}
	

}
