package com.qa.dfe.service;


import java.util.List;
import java.util.Optional;



import org.springframework.stereotype.Service;

import com.qa.dfe.data.Nationality;
import com.qa.dfe.exception.NationailtynotFoundException;
import com.qa.dfe.repo.NationalityRepo;

@Service
public class NationalityService {

	private NationalityRepo repo;

	public NationalityService(NationalityRepo repo) {
		super();
		this.repo = repo;
	}

	public Nationality getNationalityByIndex(Integer id) {
		return this.repo.findById(id).orElseThrow(NationailtynotFoundException::new);
	}

	public List<Nationality> getAllNationalitys() {
	
		return this.repo.findAll();
	}

	public Nationality createNationality(Nationality nationality) {
		return this.repo.save(nationality);
	}

	public Nationality updateNationality(Nationality nationality, Integer id) {

		Optional<Nationality> optionalNationality = this.repo.findById(id); // mocked
		Nationality toUpdate = optionalNationality.get(); // not mocked

		toUpdate.setNation(nationality.getNation());

		return this.repo.save(toUpdate); 
	}

	
	public boolean deleteNationality(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

	

}