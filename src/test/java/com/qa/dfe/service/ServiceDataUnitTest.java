package com.qa.dfe.service;




import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.dfe.data.FootballPlayers;
import com.qa.dfe.repo.FootballPlayersRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceDataUnitTest {
	
	@Autowired
	private ServiceDB service;
	
	@MockBean
	private FootballPlayersRepo repo;
	
	@Test
	void testGetByName() {
		final String name = "Messi";
		final List<FootballPlayers> FootballPlayers = List.of(new FootballPlayers(1, name, "PSG", "ligueone"));

		Mockito.when(this.repo.findByName(name)).thenReturn(FootballPlayers);

		assertThat(this.service.getFootballPlayersByName(name)).isEqualTo(FootballPlayers);

		Mockito.verify(this.repo, Mockito.times(1)).findByName(name);
	}

	@Test
	void testGetById() {
		final Integer Id = 1;
		final FootballPlayers FootballPlayers = new FootballPlayers(Id, "Messi", "PSG", "Red");

		Mockito.when(this.repo.findById(Id)).thenReturn(Optional.of(FootballPlayers));

		assertThat(this.service.getFootballPlayersByIndex(Id)).isEqualTo(FootballPlayers);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}

	@Test
	void testGetAllFootballPlayerss() {
		final List<FootballPlayers> FootballPlayers = List.of(new FootballPlayers(1, "Messi", "PSG", "ligueone"),
				new FootballPlayers(2, "Kante", "Chelsea", "prem"));

		Mockito.when(this.repo.findAll()).thenReturn(FootballPlayers);

		assertThat(this.service.getAllFootballPlayers()).isEqualTo(FootballPlayers);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdate() {
		final Integer id = 1;
		FootballPlayers footballplayers = new FootballPlayers(1,"Messi","PSG","ligueone");
		Optional<FootballPlayers> optionalFootballPlayers = Optional.of(footballplayers);
		
		FootballPlayers newFootballPlayers = new FootballPlayers(1,"Ziyech","Chelsea","prem");
		
		Mockito.when(this.repo.findById(footballplayers.getId())).thenReturn(optionalFootballPlayers);
		Mockito.when(this.repo.save(newFootballPlayers)).thenReturn(newFootballPlayers);
		
		assertThat(this.service.updateFootballPlayers(newFootballPlayers, footballplayers.getId())).isEqualTo(newFootballPlayers);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newFootballPlayers);
	}
	
	@Test
	void testCreate() {
		FootballPlayers newFootballPlayers = new FootballPlayers(null, "Messi", "PSG", "ligueone");
		FootballPlayers savedFootballPlayers = new FootballPlayers(1, "Messi", "PSG", "ligueone");

		Mockito.when(this.repo.save(newFootballPlayers)).thenReturn(savedFootballPlayers);

		assertThat(this.service.createFootballPlayers(newFootballPlayers)).isEqualTo(savedFootballPlayers);

		Mockito.verify(this.repo, Mockito.times(1)).save(newFootballPlayers);
	}



		
		
	    
	}



