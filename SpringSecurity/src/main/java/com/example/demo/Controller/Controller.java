package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AspectJ.TrackTime;
import com.example.demo.Exception.EtudiantNotFound;
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
	
	
	
	
	@PostMapping(value="/AddStudent")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Etudiant AddEtudiant(@RequestBody Etudiant etudiant)
	{
		
		
		return serviceStudent.SaveStudent(etudiant);
		
	}
	
	
	
	@GetMapping("/etudiants/{id}")
	public Etudiant findEtudiantById(@PathVariable Long id)
	{
		return etudiantRepository.findById(id).orElseThrow(()->new EtudiantNotFound(id));
		
	}
	
	
	
	
	
	
	
	
	

}
