package com.qa.dfe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.dfe.data.FootballPlayers;

public interface FootballPlayersRepo extends JpaRepository<FootballPlayers, Integer> {

	List<FootballPlayers> findByName(String name);
	
}
