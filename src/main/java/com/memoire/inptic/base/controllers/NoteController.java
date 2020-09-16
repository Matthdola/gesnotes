package com.memoire.inptic.base.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.memoire.inptic.base.models.Etudiant;
import com.memoire.inptic.base.models.Evaluation;
import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.models.Note;
import com.memoire.inptic.base.services.EtudiantsServices;
import com.memoire.inptic.base.services.EvaluationsServices;
import com.memoire.inptic.base.services.FilieresServices;
import com.memoire.inptic.base.services.NoteService;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private EtudiantsServices etudiantService;
	
	@Autowired 
	private FilieresServices filiereService;
	
	@Autowired 
	private EvaluationsServices evaluationService;
	
	private Integer filiereid;
	
	
	@GetMapping("/notes")
	public String getAll(Model model) {
		List <Note> noteListe = noteService.getAll();
		model.addAttribute("notes", noteListe);
		
		
		List<Filiere> filiereListe = filiereService.getAll();
		model.addAttribute("filieres", filiereListe);
		model.addAttribute("filiere", null);
		
		List<Evaluation> evaluationListe = evaluationService.getAll();
		model.addAttribute("evaluations", evaluationListe);
		
		return "notes";
	}
	
	
	public List<Note> getAll(Evaluation evaluation, Model model){
		if (evaluation == null) {
            return new ArrayList<>();
        }
        List<Note> notes = noteService.getAll(evaluation);

        if (notes.isEmpty()) {
        	this.getEtudiantsByFiliere(filiereid, model);
            List<Etudiant> etudiants = new ArrayList<Etudiant>();
            notes = new ArrayList<>();
            for (Etudiant etudiant : etudiants) {
                Note note = new Note();
                note.setEtudiant(etudiant);
                note.setEvaluation(evaluation);
                notes.add(note);
            }
        }

        return notes;
	}
	
	@GetMapping("/filieres/{id}/etudiants")
	public void getEtudiantsByFiliere(@PathVariable("id") Integer id, Model model){
		
		Optional<Filiere> tempFiliere = filiereService.getOne(id);
		
		if(tempFiliere.isPresent()) {
			Filiere filiere = tempFiliere.get();
			model.addAttribute("filiere", filiere);
			// return filiere.getEtudiants();
		}
		// return null;
		
	}

}
