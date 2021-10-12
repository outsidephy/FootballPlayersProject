package com.qa.dfe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.dfe.data.FootballPlayers;

//@Primary
@Service
public class ServiceList implements ServiceData {

	private List<FootballPlayers> footballplayers = new ArrayList<>();

	@Override
	public FootballPlayers getFootballPlayersByIndex(Integer id) {

		return this.footballplayers.get(id);
	}

	@Override
	public List<FootballPlayers> getAllFootballPlayers() {

		return this.footballplayers;
	}

	@Override
	public FootballPlayers createFootballPlayers(FootballPlayers footballplayers) {
		System.out.println("CREATED PLAYER: " + footballplayers);
		this.footballplayers.add(footballplayers);
		return this.footballplayers.get(this.footballplayers.size() - 1);
	}

	@Override
	public FootballPlayers updateFootballPlayers(FootballPlayers footballplayers, Integer id) {
		System.out.println("UPDATED PLAYER: " + footballplayers);
		System.out.println("ID: " + id);
		return this.footballplayers.set(id, footballplayers); 
	}

	@Override
	public void deleteFootballPlayers(Integer id) {
		FootballPlayers toDelete = this.footballplayers.get(id);
		this.footballplayers.remove(toDelete);
	}

}