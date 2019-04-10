package com.example.demo.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude="Courses")
@Data
public class Etudiant {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "id_etudiant")
	private  Long id_etudiant;
	private  String Nom;
	private  String Prenom ;
	private  LocalDate DateNaissance ;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="etudiant")
	@JsonManagedReference
    public Set<Cours> Courses;
	
	








}
