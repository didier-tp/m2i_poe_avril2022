package com.m2i.tp.appliSpringJpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Projet {
	
	@Id //@Id pour dire que code est l'identifiant (primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
	
	private String nom;
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_debut")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_fin")
	private Date dateFin;
	
	private Double montant;
	
	//la relation inverse vis à vis de @ManyToOne (facultatif)
	@OneToMany(mappedBy = "projet", fetch = FetchType.LAZY ,
			   cascade = CascadeType.REMOVE) //valeur de mappedBy = nom java de la relation inverses
	//CascadeType.REMOVE (cascade-delete ici car composition dans diagramme UML)
	//si on supprime un projet , cela supprimera automatiquement toutes les phases du projet
	private List<Phase> phases;
	
	

	@Override
	public String toString() {
		return "Projet [code=" + code + ", nom=" + nom + ", description=" + description + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", montant=" + montant + "]";
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public Projet() {
		super();
	}

	public Projet(Long code, String nom, String description, Date dateDebut, Date dateFin, Double montant) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.montant = montant;
	}

	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	//....
	
}
