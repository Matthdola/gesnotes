package com.memoire.inptic.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.memoire.inptic.base.models.Semestre;
import com.memoire.inptic.base.repositories.SemestresRepository;

@Service
public class SemestresServices {
	
	@Autowired
	private SemestresRepository semestresRepository;
	
	public List<Semestre> getAll (){
		return (List<Semestre>) semestresRepository.findAll();
		
	}
	
	public void addNew (Semestre semestre) {
		semestresRepository.save(semestre);
	
	 }

	public void delete (Integer id) {
		 semestresRepository.deleteById(id);
	}
	
	public void update (Semestre semestre) {
		semestresRepository.save(semestre);
	}
}
