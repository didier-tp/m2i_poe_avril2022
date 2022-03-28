package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numEtRue;
	
	@Column(name = "code_postal" , length=12)
	private String codePostal;
	
	private String ville;
	
	public Adresse(Long id, String numEtRue, String codePostal, String ville) {
		super();
		this.id = id;
		this.numEtRue = numEtRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numEtRue=" + numEtRue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
	

}
