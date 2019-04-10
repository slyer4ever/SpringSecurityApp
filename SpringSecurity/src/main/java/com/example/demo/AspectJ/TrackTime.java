package com.example.demo.AspectJ;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Retention(RUNTIME)
@Target(METHOD)
public @interface TrackTime {
	
	
	@Aspect
	@Configuration
	public class MethodExecutionCalculationAspect {

		private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Around("@annotation(com.example.demo.AspectJ.TrackTime)")
		public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
			long startTime = System.currentTimeMillis();

			Object o =joinPoint.proceed();

			long timeTaken = System.currentTimeMillis() - startTime;
			logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
			
			return o;
		}
	}
	
	

}
