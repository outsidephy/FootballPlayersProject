package com.qa.dfe.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfe.data.FootballPlayers;
import com.qa.dfe.service.ServiceData;



@RestController
public class DFEController {
	
	private ServiceData service;


	private DFEController(ServiceData service) {
		super();
		this.service = service;
	}

	@GetMapping("/getFootballPlayers/{id}") 
	public FootballPlayers getFootballPlayersByIndex(@PathVariable Integer id) {
	return this.service.getFootballPlayersByIndex(id);
}
	@GetMapping("/getFootballPlayersByName/{name}") 
	public List<FootballPlayers> getFootballPlayersByName(@PathVariable String name) {
	return this.service.getFootballPlayersByName(name);
}

    @GetMapping("/getAllFootballPlayers")
    public List<FootballPlayers> getAllFootballPlayers(){
	return this.service.getAllFootballPlayers();
}

@PostMapping("/createFootballPlayers")
public ResponseEntity<FootballPlayers> createFootballPlayers(@RequestBody FootballPlayers footballplayers) {
	FootballPlayers responseBody = this.service.createFootballPlayers(footballplayers);
	ResponseEntity<FootballPlayers> response = new ResponseEntity<FootballPlayers>(responseBody, HttpStatus.CREATED);
	return response;
	
}

@PutMapping("/updateFootballPlayers/{id}")
public ResponseEntity<FootballPlayers> updateFootballPlayers(@RequestBody FootballPlayers footballplayers, @PathVariable Integer id) {
	FootballPlayers responseBody = this.service.updateFootballPlayers(footballplayers, id);
	return new ResponseEntity<FootballPlayers>(responseBody,HttpStatus.ACCEPTED);
}

@DeleteMapping("/removeFootballPlayers/{id}")
public ResponseEntity<?> deleteFootballPlayers (@PathVariable Integer id) {
	this.service.deleteFootballPlayers(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
