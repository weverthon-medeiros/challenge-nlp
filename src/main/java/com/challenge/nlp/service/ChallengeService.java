package com.challenge.nlp.service;

import java.util.List;

import com.challenge.nlp.model.Match;

public interface ChallengeService {

	/**
	 * Method to find Geonames in Text
	 * @param text
	 * @return matches
	 */
	public List<Match> listMatchesInText(Integer strategy,String text);
}
