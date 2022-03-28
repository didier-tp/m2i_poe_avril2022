package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Employe.findEmployeWithNameBeginBy",
            query="SELECT e FROM Employe e WHERE e.lastname LIKE :debut")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_employe" , discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("Employe") // valeur par defaut = nom classe courante
public class Employe {
	
   @Column(name="EMP_ID")
   @Id //@Id pour dire que empId est l'identifiant (primary key)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@GeneratedValue pour dire que la valeur de empId sera générée
   //par auto-incrémentation par la base de donnée
   //lors d'un insert into sql (déclenché via entityManager.persist()
   //@GeneratedValue permet aussi de bien remontée en mémoire 
   //dans l'attribut empId la valeur auto-incrémentée par la base
   //La strategie IDENTITY est une manière d'auto-incrémenter
   //qui est compatible avec les versions récentes de MySql/MariaDB , Postgres , H2,  Oracle , ... 
   private Long empId; // 1 ou  34 ou  6789 ou null
   
   private String firstname;
   
   private String lastname;
   
   @Column(name="PHONE_NUMBER") //attention piège (avec MySql sous linux , il y a différence entre minuscule/majuscule sur nom de colonne , mais pas sous windows)
   private String phoneNumber;
   
   private String email;

   @Column(name="LOGIN",length = 32) //pour VARCHAR(32) si table créée automatiquement
   private String login;
   
   private String password;
   
   //constructeur par defaut obligatoire pour le fonctionnement de jpa/hibernate
public Employe() {
	super();
}


//autre(s) constructeur(s) facultatif(s)
public Employe(Long empId, String firstname, String lastname, String phoneNumber, String email, String login,
		String password) {
	super();
	this.empId = empId;
	this.firstname = firstname;
	this.lastname = lastname;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.login = login;
	this.password = password;
}



@Override
public String toString() {
	return "Employe [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber="
			+ phoneNumber + ", email=" + email + ", login=" + login + ", password=" + password + "]";
}

public Long getEmpId() {
	return empId;
}

public void setEmpId(Long empId) {
	this.empId = empId;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


   
   
}
