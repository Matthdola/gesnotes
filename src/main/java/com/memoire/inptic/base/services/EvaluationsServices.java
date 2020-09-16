package com.memoire.inptic.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.inptic.base.models.Evaluation;
import com.memoire.inptic.base.repositories.EvaluationsRepository;

@Service
public class EvaluationsServices {
	@Autowired
	private EvaluationsRepository evaluationsRepository;
 
	public List<Evaluation> getAll (){
		return (List<Evaluation>) evaluationsRepository.findAll();
		
		
	}
	
	public void addNew (Evaluation evaluation) {
		evaluationsRepository.save(evaluation);
		
	}
	
	public void delete (Integer id) {
		evaluationsRepository.deleteById(id);
	}
	
	public void update (Evaluation evaluation) {
		evaluationsRepository.save(evaluation);
	}
}
