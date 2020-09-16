package com.memoire.inptic.base.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.repositories.FilieresRepository;

@Service
public class FilieresServices {
	@Autowired
	private FilieresRepository filieresRepository;
	
	public List<Filiere> getAll (){
		return (List<Filiere>) filieresRepository.findAll();
	}
	
	public void addNew (Filiere filiere) {
		filieresRepository.save(filiere);
	}
	
	public Optional<Filiere> getOne(Integer id) {
		return filieresRepository.findById(id);
	}
	
	public void delete (Integer id) {
		filieresRepository.deleteById(id);
	}
	
	public void update (Filiere filiere) {
		filieresRepository.save(filiere);
	}
}

