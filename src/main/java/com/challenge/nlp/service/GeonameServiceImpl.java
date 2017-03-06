package com.challenge.nlp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.nlp.model.Geoname;
import com.challenge.nlp.repository.GeonameRepository;

@Service
@Transactional
public class GeonameServiceImpl implements GeonameService {

	@Autowired
	GeonameRepository geonameRepository;

	public List<Geoname> findByName(String name) {

		return geonameRepository.findByName(name);
		
	}
}