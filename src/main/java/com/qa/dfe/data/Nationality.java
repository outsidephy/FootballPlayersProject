package com.qa.dfe.data;

import java.util.Objects;

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
	
	

	public Nationality(Integer id, String nation) {
		super();
		this.id = id;
		this.nation = nation;
	}
	
	public Nationality() {
		super();
	}

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

	@Override
	public String toString() {
		return "Nationality [id=" + id + ", nation=" + nation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nationality other = (Nationality) obj;
		return Objects.equals(id, other.id) && Objects.equals(nation, other.nation);
	}


	}



	



