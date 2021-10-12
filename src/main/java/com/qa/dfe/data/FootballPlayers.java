package com.qa.dfe.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FootballPlayers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	
	private String teamName;
	
	private String divison;
	
	
	public FootballPlayers(Integer id, String name, String teamName, String divison) {
		super();
		this.id = id;
		this.name = name;
		this.teamName = teamName;
		this.divison = divison;
	}

	
	
	public FootballPlayers() {
		super();
	}
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getDivison() {
		return divison;
	}

	public void setDivison(String divison) {
		this.divison = divison;
	}

	@Override
	public String toString() {
		return "FootballPlayers [name=" + name + ", teamName=" + teamName + ", divison=" + divison + "]";
	}


	
	

}