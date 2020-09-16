package com.memoire.inptic.base.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.memoire.inptic.base.models.Semestre;
import com.memoire.inptic.base.services.SemestresServices;

@Controller
@RequestMapping ("/semestres")
public class SemestresController {
	
	@Autowired
	private SemestresServices semestresServices;
	
	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List <Semestre> semestre = semestresServices.getAll();
		model.addAttribute("semestres", semestre);
		return "semestres";
	}
	
	@PostMapping("/addNew")
	public String addNew(Semestre semestre) {
		semestresServices.addNew(semestre);
		return "redirect:/semestres/getAll";
		
	}
	
	@RequestMapping (value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
	 semestresServices.delete(id);
	 return "redirect:/etudiants/getAll";
	  
	}
	
	@RequestMapping (value = "/update" , method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Semestre semestre) {
		semestresServices.update(semestre);
		return "redirect:/semestres/getAll";
	}
}
