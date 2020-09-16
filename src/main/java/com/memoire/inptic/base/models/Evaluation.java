package com.memoire.inptic.base.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEvaluation;
	
     @ManyToOne
     @JoinColumn(name = "matiereid" , insertable = false, updatable = false)
     private Matiere matiere;
     private Integer matiereid;

	public Evaluation() {
		super();
	}

	public Evaluation(Integer id, Date dateEvaluation, Matiere matiere) {
		super();
		this.id = id;
		this.dateEvaluation = dateEvaluation;
		this.matiere = matiere;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateEvaluation() {
		return dateEvaluation;
	}

	public void setDateEvaluation(Date dateEvaluation) {
		this.dateEvaluation = dateEvaluation;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Integer getMatiereid() {
		return matiereid;
	}

	public void setMatiereid(Integer matiereid) {
		this.matiereid = matiereid;
	}

	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", dateEvaluation=" + dateEvaluation + ", matiere=" + matiere + ", matiereid="
				+ matiereid + "]";
	}
	
}
