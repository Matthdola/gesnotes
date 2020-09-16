package com.memoire.inptic.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memoire.inptic.base.models.Evaluation;
import com.memoire.inptic.base.models.Matiere;
import com.memoire.inptic.base.services.EvaluationsServices;
import com.memoire.inptic.base.services.MatieresServices;

@Controller
@RequestMapping ("/evaluations")
public class EvaluationsController {
	
	@Autowired
	private EvaluationsServices evaluationsServices;
	
	@Autowired
	private MatieresServices matiereService;
	
	@RequestMapping ("/getAll")
    public String getAll (Model model) {
		List <Evaluation> evaluation = evaluationsServices.getAll();
		model.addAttribute("evaluations", evaluation);
		
		List <Matiere> matiere = matiereService.getAll();
		model.addAttribute("matieres", matiere);
		
		return "evaluations";
	}
	
	@PostMapping ("/addNew")
	public String addNew (Evaluation evaluation) {
		evaluationsServices.addNew(evaluation);
		return "redirect:/etudiants/getAll";
	}
	
	@RequestMapping (value = "/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String delete (Integer id) {
		evaluationsServices.delete(id);
		return "redirect:/etudiants/getAll";
	}
	
	@RequestMapping (value = "/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String update (Evaluation evaluation) {
		evaluationsServices.update(evaluation);
		return "redirect:/etudiants/getAll";
	}
	
}
