package com.qa.dfe.service;




import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.dfe.data.FootballPlayers;
import com.qa.dfe.repo.FootballPlayersRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ServiceListUnitTest {
	
	@Autowired
	private ServiceList service;
	
	@MockBean
	private FootballPlayersRepo repo;
	

	@Test
	void testCreate() {
		FootballPlayers newFootballPlayers = new FootballPlayers(null, "Messi", "PSG", "ligueone");
		FootballPlayers savedFootballPlayers = new FootballPlayers(null, "Messi", "PSG", "ligueone");

		Mockito.when(this.repo.save(newFootballPlayers)).thenReturn(savedFootballPlayers);
		assertThat(this.service.createFootballPlayers(newFootballPlayers)).isEqualTo(savedFootballPlayers);

	Mockito.verify(this.repo, Mockito.times(1)).save(newFootballPlayers);
	}



		
		
	    
	}
