package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.dao.Compte;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
    	
    	
    	UserDetails compte=new Compte("NHA","123","ADMIN",null);
		
		
    	UserDetails compte2=new Compte("HAN","123","USER",null);
		
		
		
    	UserDetails compte3=new Compte("AAA","123","USER",null);
		
    	


        return new InMemoryUserDetailsManager(Arrays.asList(
                compte,compte2,compte3
        ));
    }
}