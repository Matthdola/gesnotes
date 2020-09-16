package com.memoire.inptic.base.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.memoire.inptic.base.models.Filiere;

@Repository
public interface FilieresRepository extends CrudRepository<Filiere, Integer> {
	

	
}
