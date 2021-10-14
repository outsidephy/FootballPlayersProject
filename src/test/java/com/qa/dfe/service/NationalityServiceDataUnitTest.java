package com.qa.dfe.service;




import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.dfe.data.Nationality;
import com.qa.dfe.data.Nationality;
import com.qa.dfe.repo.NationalityRepo;
import com.qa.dfe.repo.NationalityRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class NationalityServiceDataUnitTest {
	
	@Autowired
	private NationalityService service;
	
	@MockBean
	private NationalityRepo repo;
	


	@Test
	void testGetNationalityById() {
		final Integer Id = 1;
		final Nationality Nationality = new Nationality(Id, "France");

		Mockito.when(this.repo.findById(Id)).thenReturn(Optional.of(Nationality));

		assertThat(this.service.getNationalityByIndex(Id)).isEqualTo(Nationality);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}

	@Test
	void testgetAllNationalitys() {
		final List<Nationality> Nationality = List.of(new Nationality(1, "France"),
				new Nationality(2, "England"));

		Mockito.when(this.repo.findAll()).thenReturn(Nationality);

		assertThat(this.service.getAllNationalitys()).isEqualTo(Nationality);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdateNationality() {
		final Integer id = 1;
		Nationality Nationality = new Nationality(1,"France");
		Optional<Nationality> optionalNationality = Optional.of(Nationality);
		
		Nationality newNationality = new Nationality(1,"England");
		
		Mockito.when(this.repo.findById(Nationality.getId())).thenReturn(optionalNationality);
		Mockito.when(this.repo.save(newNationality)).thenReturn(newNationality);
		
		assertThat(this.service.updateNationality(newNationality, Nationality.getId())).isEqualTo(newNationality);
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newNationality);
	}
	
	@Test
	void testCreateNationality() {
		Nationality newNationality = new Nationality(null, "France");
		Nationality savedNationality = new Nationality(1, "France");

		Mockito.when(this.repo.save(newNationality)).thenReturn(savedNationality);

		assertThat(this.service.createNationality(newNationality)).isEqualTo(savedNationality);

		Mockito.verify(this.repo, Mockito.times(1)).save(newNationality);
	}



		
		
	    
	}



