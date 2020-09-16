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
import org.springframework.web.bind.annotation.ResponseBody;


import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.services.FilieresServices;

@Controller

public class FilieresController {
	
	@Autowired
	private FilieresServices filieresServices;
	
	@GetMapping ("/filieres")
	public String getAll (Model model) {
		List <Filiere> filiere = filieresServices.getAll();
		model.addAttribute("filieres", filiere);
		return "filieres";
	}

	@PostMapping ("/filieres/addNew")
	public String addNew(Filiere filiere) {
		filieresServices.addNew(filiere);
		return "redirect:/filieres";
	}
	
	@RequestMapping("/filieres/getOne")
	@ResponseBody
	public Optional<Filiere> getOne(Integer id) {
		return filieresServices.getOne(id);
	}
	
	@RequestMapping (value = "/filieres/delete", method = {RequestMethod.DELETE , RequestMethod.GET})
	public String delete(Integer id) {
		filieresServices.delete(id);
		return "redirect:/etudiants";
	}
	
	@RequestMapping(value = "/filieres/update", method = {RequestMethod.PUT , RequestMethod.GET})
	public String update(Filiere filiere) {
		filieresServices.update(filiere);
		return "redirect:/etudiants";
	}
}
