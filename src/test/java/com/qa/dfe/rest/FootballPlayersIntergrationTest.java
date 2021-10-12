package com.qa.dfe.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfe.data.FootballPlayers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FootballPlayersIntergrationTest {
	
   @Autowired 
   private MockMvc mvc;
   
   @Autowired
   private ObjectMapper mapper;
   
   @Test
 
   void testCreate() throws Exception {
		final FootballPlayers testFootballPlayers = new FootballPlayers(null, "Ziyech", "Chelsea", "PremierLeague");
		String testFootballPlayersAsJSON = this.mapper.writeValueAsString(testFootballPlayers);

		final FootballPlayers savedFootballPlayers = new FootballPlayers(1, "Ziyech", "Chelsea", "PremierLeague");
		String savedFootballPlayersAsJSON = this.mapper.writeValueAsString(savedFootballPlayers);

		RequestBuilder request = post("/createFootballPlayers").contentType(MediaType.APPLICATION_JSON)
				.content(testFootballPlayersAsJSON);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkContent = content().json(savedFootballPlayersAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkContent);

}
}
	


