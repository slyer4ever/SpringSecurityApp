package com.example.demo.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspectProject {
	
	//@Pointcut("execution(* com.example.demo.service.*())")
	
	
	
	@Before(("execution(* com.example.demo.service.*.*(..))"))
	public void logBefore(JoinPoint joinPoint) {
		
		 final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		 logger.info("logBefore() is running!");
		 logger.info("hijacked : " + joinPoint.getSignature().getName());
		 logger.info("******");
		 
		 /*
		 System.out.println("logBefore() is running!");
		 System.out.println("hijacked : " + joinPoint.getSignature().getName());
		 System.out.println("******");*/
		
		
	}
	
	
	/*@Around(("execution(* com.example.demo.service.*.*(..))"))
	public void TimerServiceStudent(JoinPoint joinPoint) throws Throwable  {
		
		 final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		 long startTime = System.currentTimeMillis();

		
			 ((ProceedingJoinPoint) joinPoint).proceed();
			  
	

			long timeTaken = System.currentTimeMillis() - startTime;
			logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
		 
		 /*
		 System.out.println("logBefore() is running!");
		 System.out.println("hijacked : " + joinPoint.getSignature().getName());
		 System.out.println("******");
		
		
	}*/
	
	
	
}
