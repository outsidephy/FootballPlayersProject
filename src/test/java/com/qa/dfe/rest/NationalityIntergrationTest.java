package com.qa.dfe.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfe.data.Nationality;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:nationality-schema.sql", 
		"classpath:nationality-data.sql" }, executionPhase  = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class NationalityIntergrationTest {
	
   @Autowired 
   private MockMvc mvc;
   
   @Autowired
   private ObjectMapper mapper;
   
   
   @Test
 
   void testCreate() throws Exception {
		final Nationality testNationality = new Nationality(null, "France");
		String testNationalityAsJSON = this.mapper.writeValueAsString(testNationality);

		final Nationality savedNationality = new Nationality(2, "France");
		String savedNationalityAsJSON = this.mapper.writeValueAsString(savedNationality);

		RequestBuilder request = post("/createNationality").contentType(MediaType.APPLICATION_JSON)
				.content(testNationalityAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedNationalityAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

}

    





@Test 
void testGetById() throws Exception{
	   final Nationality savedNationality = new Nationality(1, "France");
	   String saveNationalityAsJSON = this.mapper.writeValueAsString(savedNationality);
	   
	   RequestBuilder request = get("/getNationality/" + savedNationality.getId());
	   
	   ResultMatcher checkStatus = status().isOk();
	   ResultMatcher checkContent = content().json(saveNationalityAsJSON);
	   
	   this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	   
}
	


	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeNationality/1")).andExpect(status().isNoContent());
	}
}
	


