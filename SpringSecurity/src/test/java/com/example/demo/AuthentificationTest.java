package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.dao.Compte;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.junit.Before;



@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityWebAuxTestConfig.class
)
@AutoConfigureMockMvc
public class AuthentificationTest {
	
	

	 /* @Autowired
	  private WebApplicationContext context;

	  @Autowired
	  private Filter springSecurityFilterChain;
*/
		@Autowired
	  private MockMvc mvc;
	  
	  
	  
	//  private UserDetails userDetails=new Compte("NHA","1234","ADMIN",null);

	/*  @Before
	  public void setup() {
	      mvc = MockMvcBuilders
	              .webAppContextSetup(context)
	              .addFilters(springSecurityFilterChain)
	              .build();
	  }*/
	
	
	/*  @Test

	  public void TestAuth() throws Exception
	  {
		   List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		    grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		 
		  
		  
		  mvc
		    .perform(formLogin("/login").user("NHA").password("123")).andExpect(authenticated()
		    		.withAuthorities(grantedAuthorities));
		  mvc.perform(get("/comptes").accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				  .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		  .andExpect(redirectedUrl("http://localhost/login")).andExpect(status().is3xxRedirection()).andReturn()
		  ;
		  
		   
		  
	  }*/
	  
	  
	  /*	@Test
	    @WithUserDetails("HAN")
	    public void givenManagerUser_whenGetFooSalute_ForbiddenOk() throws Exception
	    {
	        mvc.perform(MockMvcRequestBuilders.get("/etudiants")
	                .accept(MediaType.ALL))
	                .andExpect(status().isForbidden());
	               // .andExpect(content().string(containsString("Java")));
	    }
	  */
	  	
		@Test
	    @WithUserDetails("NHA")
	    public void givenManagerUser_whenGetFooSalute_thenOk() throws Exception
	    {
	        mvc.perform(MockMvcRequestBuilders.get("/etudiants")
	                .accept(MediaType.ALL))
	                .andExpect(status().isOk())
	                .andExpect(content().string(containsString("Java")));
	    }
	  
	  
	  
	  
	  

}
