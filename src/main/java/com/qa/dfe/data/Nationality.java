package com.qa.dfe.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nationality {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	private String nation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}


	}

	



