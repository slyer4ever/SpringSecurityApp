package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AspectJ.TrackTime;
import com.example.demo.Exception.EtudiantNotFound;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.CoursesRepository;
import com.example.demo.Repository.EtudiantRepository;
import com.example.demo.dao.Compte;
import com.example.demo.dao.Cours;
import com.example.demo.dao.Etudiant;

import com.example.demo.service.ServiceStudent;

@RestController
public class Controller {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	CoursesRepository coursesRepository;
	
	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	@Autowired
	CompteRepository compteRepository;
	
	@Autowired
	ServiceStudent serviceStudent;
	
	

	
	@TrackTime
	@GetMapping("/All_ET")
	//@Secured("ROLE_ADMIN")
	public List<Etudiant> AllEtudiants()
	{
	
		return serviceStudent.FindAllEtudiants();
		
	}
	
	
	@GetMapping("/EtudiantByCP")
	public List<Map<Long, Map<String, Object>>> returnEtudiantByCP()
	{
		return serviceStudent.findAllEtudiantJoinCours();
		
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
	
	

	@GetMapping("/etudiantss")
	public List<Etudiant> findEtudiants()
	{
		return etudiantRepository.findAll();
		
	}
	
	
	

	
	@GetMapping("/CurrentUser")
	public String currentUser() {
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		

		 if (principal instanceof UserDetails) {
			
			
			return ((UserDetails)principal).getUsername();
				 
		 }else
		 {
			 
			 return "VOID";
			 
		 }
		
	}
	
	
	
	@PostMapping(value="/AddAccount")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Compte AddAccount(@RequestBody Compte compte)
	{
		
		Compte tmp =  new Compte(compte.getUsername(),compte.getPassword(),compte.getRole(),null);
		//new Compte("bbb","123","ADMIN",null);
		tmp.setPassword(bCryptPasswordEncoder.encode(tmp.getPassword()));
		return compteRepository.save(tmp);		
	}
	
	
	@GetMapping("/comptes")
	public List<Compte> findComptes()
	{
		return compteRepository.findAll();
		
	}
	
	
	
	@PostMapping(value="/UpdateAccount")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Compte UpdateAccount(@RequestBody Compte compte)
	{
		
		
		return compteRepository.save(compte);
		
	}
	
	
	
	
	
	

}
