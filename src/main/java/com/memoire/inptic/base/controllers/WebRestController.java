package com.memoire.inptic.base.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoire.inptic.base.message.Response;
import com.memoire.inptic.base.models.Filiere;
import com.memoire.inptic.base.services.FilieresServices;

@RestController
@RequestMapping("/api")
public class WebRestController {
	@Autowired 
	private FilieresServices filiereService;
	
	
	@GetMapping(value = "/filiere/{id}")
	public Response getFiliere(@PathVariable("id") Integer id) {
		Optional<Filiere> tempFiliere = filiereService.getOne(id);
		Response response = new Response();
		
		if(tempFiliere.isPresent()) {
			Filiere filiere = tempFiliere.get();
			response.setData(filiere);
			response.setStatus("200");
			System.out.println(filiere);
			return response;
		}
		response.setStatus("404");
		response.setData(null);
		return response;
	}
	
}
