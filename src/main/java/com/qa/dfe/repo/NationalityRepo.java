package com.qa.dfe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfe.data.Nationality;

@Repository
public interface NationalityRepo extends JpaRepository<Nationality, Integer> {

}