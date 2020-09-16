package com.memoire.inptic.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.memoire.inptic.base.models.Matiere;
import com.memoire.inptic.base.models.Semestre;
import com.memoire.inptic.base.services.MatieresServices;
import com.memoire.inptic.base.services.SemestresServices;

@Controller
@RequestMapping ("/matieres")
public class MatieresController {
	
	@Autowired
	private MatieresServices matieresServices;
	
	@Autowired
	private SemestresServices semestreService;
	
	@RequestMapping ("/getAll")
	public String getAll (Model model) {
		List <Matiere> matiere = matieresServices.getAll();
		model.addAttribute("matieres", matiere);
		
		List <Semestre> semestre = semestreService.getAll();
		model.addAttribute("semestres", semestre);
		return "matieres";
		
	}
   
	@PostMapping ("/addNew")
	public String addNew(Matiere matiere) {
		matieresServices.addNew(matiere);
		return "redirect:/matieres/getAll";
	}
	
	@RequestMapping (value = "/delete", method = {RequestMethod.DELETE , RequestMethod.GET})
	public String delete(Integer id) {
		matieresServices.delete(id);
		return "redirect:/etudiants/getAll";
	}
	
	@RequestMapping (value = "/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(Matiere matiere) {
		matieresServices.update(matiere);
		return "redirect:/etudiants/getAll";
	}

}
