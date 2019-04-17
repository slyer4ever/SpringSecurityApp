package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Cours;
import com.example.demo.service.CoursService;

@RestController
public class CoursController {
	
	
	@Autowired
	CoursService coursService;
	
	@GetMapping("/EtuToCrs/{id_etudiant}/{id_cours}")
	public Cours AffecterEtudiantToCours(@PathVariable Long id_etudiant,@PathVariable Long id_cours)
	{
		
		return coursService.AffecterEtudiantToCours(id_etudiant, id_cours);
		
	}

}
