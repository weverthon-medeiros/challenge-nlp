package com.challenge.nlp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.nlp.model.Geoname;;

@RepositoryRestResource(exported=false)
public interface GeonameRepository extends JpaRepository<Geoname, Integer>{

	public List<Geoname> findByName(String name);
	
}
