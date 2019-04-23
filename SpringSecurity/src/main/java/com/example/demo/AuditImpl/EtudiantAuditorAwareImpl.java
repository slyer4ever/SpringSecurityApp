package com.example.demo.AuditImpl;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.dao.Compte;

import ch.qos.logback.classic.Logger;

@Component
public class EtudiantAuditorAwareImpl implements AuditorAware<String> {

	 final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Optional<String> getCurrentAuditor() {
	
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        
        String username = ((Compte) authentication.getPrincipal()).getUsername();
        
        logger.info("*****************");
        logger.info("*****************");
        logger.info("*****************");
        logger.info("User Name : "+username);
        logger.info("*****************");
        logger.info("*****************");
	
        return Optional.of(((Compte) authentication.getPrincipal()).getUsername());
	}
}
		
		/*
		   return Optional.ofNullable(SecurityContextHolder.getContext())
					  .map(SecurityContext::getAuthentication)
					  .filter(Authentication::isAuthenticated)
					  .map(Authentication::getPrincipal)
					  .map(Compte.class::cast);
		  }*/
		
		
		
		
	
	
	
	
	


