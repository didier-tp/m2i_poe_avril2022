package com.m2i.tp.appliSpringJpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.appliSpringJpa.entity.Employe;
import com.m2i.tp.appliSpringJpa.service.ServiceEmploye;

@RestController //composant Spring de type Web Service Rest (cas particuler de @Component)
@RequestMapping(path = "/api-gestionProjet/employe" ,
                headers="Accept=application/json")
public class EmployeRestCtrl {
	
	
	@Autowired
	private ServiceEmploye serviceEmploye;
	
	//URL http://localhost:8080/appliSpringJpa/api-gestionProjet/employe
	@GetMapping("")
	public List<Employe> getEmployes(){
		return serviceEmploye.rechercherTousEmploye();
		//la liste d'employés JAVA
		//sera automatiquement transformée et retournée au format JSON
	}

}
