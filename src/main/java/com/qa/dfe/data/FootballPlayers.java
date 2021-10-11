package com.qa.dfe.data;

public class FootballPlayers {
	
	private String name;
	private String teamName;
	private String divison;
	public FootballPlayers(String name, String teamName, String divison) {
		super();
		this.name = name;
		this.teamName = teamName;
		this.divison = divison;
	}
	
	public FootballPlayers() {
		super();
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
	public String getNationality() {
		return divison;
	}
	public void setNationality(String nationality) {
		this.divison = nationality;
	}

	@Override
	public String toString() {
		return "FootballPlayers [name=" + name + ", teamName=" + teamName + ", divison=" + divison + "]";
	}


	
	

}