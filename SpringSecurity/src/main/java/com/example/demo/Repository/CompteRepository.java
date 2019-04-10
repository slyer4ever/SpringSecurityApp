package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

}
