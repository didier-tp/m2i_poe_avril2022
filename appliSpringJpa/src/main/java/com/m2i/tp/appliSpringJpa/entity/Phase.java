package com.m2i.tp.appliSpringJpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Phase {
	
	@Id //@Id pour dire que code est l'identifiant (primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
	
	private String label;
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_fin_prevue")
	private Date dateFinPrevue;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_fin_effective")
	private Date dateFinEffective;
	
	@Column(name="proportion_projet")
	private Double proportionProjet; //ex: 0.5 pour 50%
	
	@ManyToOne()
	@JoinColumn(name="code_projet")
	private Projet projet;
	

	

	public Phase(Long code, String label, String description, Date dateDebut, Date dateFinPrevue, Date dateFinEffective,
			Double proportionProjet, Projet projet) {
		super();
		this.code = code;
		this.label = label;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFinPrevue = dateFinPrevue;
		this.dateFinEffective = dateFinEffective;
		this.proportionProjet = proportionProjet;
		this.projet = projet;
	}

	@Override
	public String toString() {
		return "Phase [code=" + code + ", label=" + label + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFinPrevue=" + dateFinPrevue + ", dateFinEffective=" + dateFinEffective + ", proportionProjet="
				+ proportionProjet + "]";
	}

	
	

}
