package com.memoire.inptic.base.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.inptic.base.models.Matiere;
import com.memoire.inptic.base.repositories.MatieresRepository;

@Service
public class MatieresServices {
	@Autowired 
	private MatieresRepository matieresRepository;
	
	public List<Matiere> getAll (){
		return (List<Matiere>) matieresRepository.findAll();
		
	}
	
	public void addNew (Matiere matiere) {
	matieresRepository.save(matiere);
	
	 }
	
	public void delete (Integer id) {
		matieresRepository.deleteById(id);
	}
	
	public void update (Matiere matiere) {
		matieresRepository.save(matiere);
	}
}
