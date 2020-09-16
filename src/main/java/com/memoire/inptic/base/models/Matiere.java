package com.memoire.inptic.base.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	
	private Integer credit;

	@ManyToOne
	@JoinColumn (name = "semestreid" , insertable = false, updatable = false)
	private Semestre semestre;
	private Integer semestreid;

	public Matiere() {
		super();
	}

	public Matiere(Integer id, String libelle, Integer credit, Semestre semestre) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.credit = credit;
		this.semestre = semestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Semestre getSemestres() {
		return semestre;
	}

	public void setSemestres(Semestre semestre) {
		this.semestre = semestre;
	}
	
	

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Integer getSemestreid() {
		return semestreid;
	}

	public void setSemestreid(Integer semestreid) {
		this.semestreid = semestreid;
	}

	@Override
	public String toString() {
		return "Matiere [id=" + id + ", libelle=" + libelle + ", credit=" + credit + ", semestre=" + semestre
				+ ", semestreid=" + semestreid + "]";
	}
	

}
