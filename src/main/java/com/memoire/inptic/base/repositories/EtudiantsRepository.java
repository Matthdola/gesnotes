package com.memoire.inptic.base.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memoire.inptic.base.models.Etudiant;
import com.memoire.inptic.base.models.Filiere;



@Repository
public interface EtudiantsRepository extends CrudRepository<Etudiant, Integer>{


	@Query("SELECT e FROM Etudiant e LEFT JOIN  e.filiere where e.filiere = :filiere")	
	public List<Etudiant> findEtudiantByFiliere(@Param("filiere")Filiere filiere);
	
}
