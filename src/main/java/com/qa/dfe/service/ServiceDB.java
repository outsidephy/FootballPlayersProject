package com.qa.dfe.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import com.qa.dfe.data.FootballPlayers;
import com.qa.dfe.repo.FootballPlayersRepo;

@Service
@Primary
public class ServiceDB implements ServiceData {
	
	private FootballPlayersRepo repo;
	
	
	public ServiceDB(FootballPlayersRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<FootballPlayers> getFootballPlayersByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public FootballPlayers getFootballPlayersByIndex(Integer id) {
	return this.repo.findById(id).get();
	}

	@Override
	public List<FootballPlayers> getAllFootballPlayers() {
		return this.repo.findAll();
	}

	@Override
	public FootballPlayers createFootballPlayers(FootballPlayers footballplayers) {
		return this.repo.save(footballplayers);
	}

	@Override
	public FootballPlayers updateFootballPlayers(FootballPlayers FootballPlayers, Integer id) {
		
		FootballPlayers toUpdate = this.repo.findById(id).get();

		toUpdate.setName(FootballPlayers.getName());
		toUpdate.setTeamName(FootballPlayers.getTeamName());
		toUpdate.setDivision(FootballPlayers.getDivision());

		return this.repo.save(toUpdate);
	}

	@Override
	public void deleteFootballPlayers(Integer id) {
		this.repo.deleteById(id);

	}

}
