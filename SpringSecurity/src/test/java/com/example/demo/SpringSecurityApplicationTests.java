package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.Before;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.context.WebApplicationContext;

import junit.framework.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.nio.charset.Charset;
import java.util.Base64;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityApplicationTests {
	
	
	final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),                        
            Charset.forName("utf8")                     
            );
	
	static final String PAYLOAD ="{\n" + 
			"\"id_etudiant\": 2,\n" + 
			"\"Courses\": [],\n" + 
			"\"courses\": [],\n" + 
			"\"dateNaissance\": \"2019-04-19\",\n" + 
			"\"prenom\": \"Snow\",\n" + 
			"\"nom\": \"Jhon\"\n" + 
			"}";
	
	@Autowired WebApplicationContext context;
	@Autowired FilterChainProxy filterChain;

	MockMvc mvc;

	@Before
	public void setUp() {

		this.mvc = webAppContextSetup(context).addFilters(filterChain).build();

		SecurityContextHolder.clearContext();
	}

	@Test
	public void allowsAccessToRootResource() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, "application/json;charset=UTF-8");
		
		headers.set(HttpHeaders.AUTHORIZATION,
				"Basic " + new String(Base64.getEncoder().encodeToString(("NHA:123").getBytes())));
		
		logger.info("the HEADER:"+ headers.toString());
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/etudiants/2").accept(MediaTypes.HAL_JSON_VALUE).headers(headers)
				;
		
		
		String result = mvc.perform(requestBuilder).andExpect(status().isOk()).
				
				andReturn().getResponse().getContentAsString();
		logger.info("the returned value is :"+ result);
		
		assertEquals(PAYLOAD, result);
		
	}

}
