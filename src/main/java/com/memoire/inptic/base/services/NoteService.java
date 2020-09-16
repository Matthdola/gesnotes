package com.memoire.inptic.base.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.inptic.base.models.Etudiant;
import com.memoire.inptic.base.models.Evaluation;
import com.memoire.inptic.base.models.Note;
import com.memoire.inptic.base.repositories.NoteRepository;

@Service
public class NoteService {
	@Autowired
	private NoteRepository noteRepository;
	
	
	public List<Note> getAll (){
		return (List<Note>) noteRepository.findAll();
		
	}
	
	
	public List<Note> getAll(Evaluation evaluation){
		
		return noteRepository.getAll(evaluation);
		
	}
	
	public void addAll (List<Note> notes) {
		noteRepository.saveAll(notes);
	
	 }

}
