package com.challenge.nlp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.nlp.model.Match;
import com.challenge.nlp.service.ChallengeService;

@RestController
public class ChallengeController {

	@Autowired
	ChallengeService challengeService;

	@RequestMapping(value = "/match/{strategy}/{text}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Match>> list(@PathVariable("strategy") Integer strategy, @PathVariable("text") String text) {
		List<Match> matches = challengeService.listMatchesInText(strategy, text);

		if (matches.isEmpty()) {
			return new ResponseEntity<List<Match>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Match>>(matches, HttpStatus.OK);
		}
	}
}
