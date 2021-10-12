package com.qa.dfe.service;

import java.util.List;

import com.qa.dfe.data.FootballPlayers;

public interface ServiceData {
	
	public List<FootballPlayers> getFootballPlayersByName(String name);
	
	public FootballPlayers getFootballPlayersByIndex(Integer id);
	
	public List<FootballPlayers> getAllFootballPlayers();

	public FootballPlayers createFootballPlayers(FootballPlayers footballplayers);

	public FootballPlayers updateFootballPlayers(FootballPlayers footballplayers, Integer id);

	public void deleteFootballPlayers(Integer id);


	
	

}
