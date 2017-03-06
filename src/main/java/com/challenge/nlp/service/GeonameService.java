package com.challenge.nlp.service;

import java.util.List;

import com.challenge.nlp.model.Geoname;

public interface GeonameService {

	/**
	 * Method to find Geoname by exactly Name
	 * @param name
	 * @return geonames
	 */
	public List<Geoname> findByName(String name);	
	
	
}
