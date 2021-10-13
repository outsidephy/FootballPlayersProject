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
import com.qa.dfe.data.FootballPlayers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:footballplayers-schema.sql", 
		"classpath:footballplayers-data.sql" }, executionPhase  = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FootballPlayersIntergrationTest {
	
   @Autowired 
   private MockMvc mvc;
   
   @Autowired
   private ObjectMapper mapper;
   
   
   @Test
 
   void testCreate() throws Exception {
		final FootballPlayers testFootballPlayers = new FootballPlayers(null, "Ziyech", "Chelsea", "prem");
		String testFootballPlayersAsJSON = this.mapper.writeValueAsString(testFootballPlayers);

		final FootballPlayers savedFootballPlayers = new FootballPlayers(3, "Ziyech", "Chelsea", "prem");
		String savedFootballPlayersAsJSON = this.mapper.writeValueAsString(savedFootballPlayers);

		RequestBuilder request = post("/createFootballPlayers").contentType(MediaType.APPLICATION_JSON)
				.content(testFootballPlayersAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedFootballPlayersAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

}

    

@Test
void testGetAll() throws Exception {
		String savedFootballPlayersAsJSON = this.mapper
				.writeValueAsString(List.of(new FootballPlayers(2, "Messi", "PSG", "ligueone")));

		RequestBuilder request = get("/getAllFootballPlayers");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkContent = content().json(savedFootballPlayersAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

@Test 
void testGetById() throws Exception{
	   final FootballPlayers savedFootballPlayers = new FootballPlayers(1, "Messi", "PSG", "ligueone");
	   String saveFootballPlayersAsJSON = this.mapper.writeValueAsString(savedFootballPlayers);
	   
	   RequestBuilder request = get("/getFootballPlayers/" + savedFootballPlayers.getId());
	   
	   ResultMatcher checkStatus = status().isOk();
	   ResultMatcher checkContent = content().json(saveFootballPlayersAsJSON);
	   
	   this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	   
}
	

	@Test
	void testUpdate() throws Exception {
		final FootballPlayers testFootballPlayers = new FootballPlayers(2, "Hazard","Realmadrid", "laliga");
		final String testFootballPlayersAsJSON = this.mapper.writeValueAsString(testFootballPlayers);

		RequestBuilder request = put("/updateFootballPlayers/2").contentType(MediaType.APPLICATION_JSON)
				.content(testFootballPlayersAsJSON);

		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkContent = content().json(testFootballPlayersAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeFootballPlayers/1")).andExpect(status().isNoContent());
	}
}
	


