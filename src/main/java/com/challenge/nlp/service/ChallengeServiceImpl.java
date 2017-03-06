package com.challenge.nlp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.challenge.nlp.model.Geoname;
import com.challenge.nlp.model.Match;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	GeonameService geonameService;

	public List<Match> listMatchesInText(Integer strategy, String text) {

		List<Match> matches = searchCoveredText(text);
//TODO implements another strategies
		switch (strategy) {
		case 1:
			return listNamesExactly(matches);
		default:
			return null;
		}

	}

	private List<Match> listNamesExactly(List<Match> matches) {
		for (Match match : matches) {
			List<Geoname> geonames = geonameService.findByName(match.getCovered_text());
			if (!geonames.isEmpty()) {
				//get the first result to return
				match.setGeonameid(geonames.get(0).getGeonameid());
				match.setName(geonames.get(0).getName());
				// Set the score according the size of result
				if (geonames.size() > 1) {
					match.setScore(1.0 / geonames.size());
				} else {
					match.setScore(1.0);
				}
			} else {
				matches.remove(match);
			}
		}
		return matches;
	}
	

	private List<Match> searchCoveredText(String text) {
		Properties props = new Properties();
		List<Match> matches = new ArrayList<Match>();

		if (StringUtils.isEmpty(text)) {
			return matches;
		} else {

			props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
			StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

			Annotation document = new Annotation(text);
			pipeline.annotate(document);
			List<CoreMap> sentences = document.get(SentencesAnnotation.class);
			System.out.println("Entrou");
			for (CoreMap sentence : sentences) {
				int previousCount = 0;
				int count = 0;

				// traversing the words in the current sentence
				// a CoreLabel is a CoreMap with additional token-specific
				// methods
				for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
					String word = token.get(CoreAnnotations.TextAnnotation.class);

					int previousWordIndex;
					if (token.get(NamedEntityTagAnnotation.class).equals("LOCATION")) {
						count++;

						if (previousCount != 0 && (previousCount + 1) == count) {
							previousWordIndex = matches.size() - 1;
							Match previousWord = matches.get(previousWordIndex);
							matches.remove(previousWordIndex);
							previousWord.setCovered_text(previousWord.getCovered_text().concat(" " + word));
							previousWord.setEnd(token.endPosition());
							matches.add(previousWordIndex, previousWord);

						} else {
							Match match = new Match(word, token.beginPosition(), token.endPosition());
							matches.add(match);
						}
						previousCount = count;

					} else {
						count = 0;
						previousCount = 0;
					}

				}
			}
			System.out.println("Saiu ---" + matches.size());
			return matches;
		}
	}

}
