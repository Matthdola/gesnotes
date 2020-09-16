package com.memoire.inptic.base.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double note; 
	
	@ManyToOne
	@JoinColumn(name = "etudiantid",insertable = false, updatable = false)
	private Etudiant etudiant;
	private Integer etdiantid;
	
	
	@ManyToOne
	@JoinColumn(name = "evaluationid", insertable = false, updatable = false)
	private Evaluation evaluation;
	
	private Integer evaluationid;

	public Note() {
		super();
	}

	



	public Note(Integer id, Double note) {
		super();
		this.id = id;
		this.note = note;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Double getNote() {
		return note;
	}


	public void setNote(Double note) {
		this.note = note;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Evaluation getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}


	public Integer getEvaluationid() {
		return evaluationid;
	}


	public void setEvaluationid(Integer evaluationid) {
		this.evaluationid = evaluationid;
	}


	public Integer getEtdiantid() {
		return etdiantid;
	}


	public void setEtdiantid(Integer etdiantid) {
		this.etdiantid = etdiantid;
	}


	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", etudiant=" + etudiant + ", etdiantid=" + etdiantid
				+ ", evaluation=" + evaluation + ", evaluationid=" + evaluationid + "]";
	}


}
