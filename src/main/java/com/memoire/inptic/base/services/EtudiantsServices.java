package com.memoire.inptic.base.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.memoire.inptic.base.models.Etudiant;
import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.repositories.EtudiantsRepository;

@Service
public class EtudiantsServices {
	@Autowired
	private EtudiantsRepository etudiantsRepository;
	
	public List<Etudiant> getAll (){
		return (List<Etudiant>) etudiantsRepository.findAll();
		
	}
	
	public Optional<Etudiant> getOne(Integer id) {
		return etudiantsRepository.findById(id);
		
	}
	
	public void addNew (Etudiant etudiant) {
		etudiantsRepository.save(etudiant);
	
	 }
	
	public void delete (Integer id) {
		 etudiantsRepository.deleteById(id);
	}
	
	public void update (Etudiant etudiant) {
		etudiantsRepository.save(etudiant);
	}
	
	
	public List<Etudiant> findEtudiantByFiliere (Filiere filiere){
		return (List<Etudiant>) etudiantsRepository.findEtudiantByFiliere(filiere);
		
	}

}
