package com.example.demo.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Cours {
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_cours;
	private String nom_cours;
	@CreatedDate private int duree_cours;

	
    @ManyToOne
    @JoinColumn(name="id_etudiant", nullable=false)
    @JsonBackReference
    public Etudiant etudiant;
}
