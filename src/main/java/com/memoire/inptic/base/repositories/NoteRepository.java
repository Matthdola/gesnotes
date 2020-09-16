package com.memoire.inptic.base.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.memoire.inptic.base.models.Evaluation;
import com.memoire.inptic.base.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

	//récupérer la liste des notes en fonction d'une évaluation
	@Query("SELECT n from Note n where n.evaluation = :evaluation")
	public List<Note> getAll(@Param("evaluation")Evaluation evaluation);
}
