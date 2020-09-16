package com.memoire.inptic.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping ("/home")
	public String text() {
		
		return "index";
	}
}
