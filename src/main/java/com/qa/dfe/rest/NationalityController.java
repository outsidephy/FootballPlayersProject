package com.qa.dfe.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfe.data.Nationality;
import com.qa.dfe.service.NationalityService;



@CrossOrigin
@RestController // enables http endpoints AND tells Spring to make a Bean of this class
public class NationalityController {

	private NationalityService service;

	public NationalityController(NationalityService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getNationality/{id}") // 200
	public Nationality getNationalityByIndex(@PathVariable Integer id) {

		return this.service.getNationalityByIndex(id);
	}

	@GetMapping("/getAllNationalitys") // 200
	public List<Nationality> getAllNationalitys() {

		return this.service.getAllNationalitys();
	}

	@PostMapping("/createNationality") // 201
	public ResponseEntity<Nationality> createNationality(@RequestBody Nationality nationality) {
		Nationality responseBody = this.service.createNationality(nationality);
		ResponseEntity<Nationality> response = new ResponseEntity<Nationality>(responseBody, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/updateNationality/{id}") // 202 - Accepted
	public ResponseEntity<Nationality> updateNationality(@RequestBody Nationality nationality, @PathVariable Integer id) {
		Nationality responseBody = this.service.updateNationality(nationality, id); // replaces the Nationality at that index
		return new ResponseEntity<Nationality>(responseBody, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeNationality/{id}") // 204 - No content
	public ResponseEntity<?> deleteNationality(@PathVariable Integer id) {
		boolean deleted = this.service.deleteNationality(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 causes the body to be ignored
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}