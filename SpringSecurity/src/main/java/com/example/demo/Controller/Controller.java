package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AspectJ.TrackTime;
import com.example.demo.Repository.CoursesRepository;
import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Cours;
import com.example.demo.dao.Etudiant;
import com.example.demo.service.ServiceStudent;

@RestController
public class Controller {
	
	
	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	ServiceStudent serviceStudent;
	
	
	@TrackTime
	@GetMapping("/All_ET")
	//@Secured("ROLE_ADMIN")
	public List<Etudiant> AllEtudiants()
	{
	
		return serviceStudent.FindAllEtudiants();
		
	}
	
	
	
	@GetMapping("/ALL_CRS")
	@TrackTime
	public List<Cours> AllCourses()
	{
		return coursesRepository.findAll();
		
	}
	

}