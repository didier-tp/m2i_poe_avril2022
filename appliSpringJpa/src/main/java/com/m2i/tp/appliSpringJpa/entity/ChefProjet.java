package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("ChefProjet") //valeur par defaut = nom classe courante
public class ChefProjet extends Employe{
    private String methodologies ; //ex: "XP;SCRUM;MERISE" ou "SCRUM"
    

	@Override
	public String toString() {
		return "ChefProjet [methodologies=" + methodologies + ", toString()=" + super.toString() + "]";
	}

	public ChefProjet() {
		super();
	}

	public ChefProjet(Long empId, String firstname, String lastname, String phoneNumber, String email, String login,
			String password) {
		super(empId, firstname, lastname, phoneNumber, email, login, password);
	}

	public String getMethodologies() {
		return methodologies;
	}

	public void setMethodologies(String methodologies) {
		this.methodologies = methodologies;
	}
    
    
}
