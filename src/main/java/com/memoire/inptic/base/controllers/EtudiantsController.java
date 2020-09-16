package com.memoire.inptic.base.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.memoire.inptic.base.models.Etudiant;
import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.services.EtudiantsServices;
import com.memoire.inptic.base.services.FilieresServices;

@Controller
public class EtudiantsController {
	
	@Autowired
	private EtudiantsServices etudiantsServices;
	
	@Autowired
	private FilieresServices filieresServices;
	
	@GetMapping("/etudiants")
	public String getAll(Model model) {
		List <Etudiant> etudiantListe = etudiantsServices.getAll();
		model.addAttribute("etudiants", etudiantListe);
		
		
		List<Filiere> filiereListe = filieresServices.getAll();
		model.addAttribute("filieres", filiereListe);
		return "etudiants";
	}
	
	@PostMapping("/etudiants/addNew")
	public String addNew(Etudiant etudiant) {
		etudiantsServices.addNew(etudiant);
		return "redirect:/etudiants";
		
	}
	
	@RequestMapping("/etudiants/getOne")
	@ResponseBody
	public Optional<Etudiant> getOne(Integer id) {
		return  etudiantsServices.getOne(id);
		
	}
	
	@RequestMapping (value = "/etudiants/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
	 etudiantsServices.delete(id);
	 return "redirect:/etudiants";
	}
	
	@RequestMapping (value = "/etudiants/update" , method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Etudiant etudiant) {
		etudiantsServices.update(etudiant);
		return "redirect:/etudiants";
	}



}
