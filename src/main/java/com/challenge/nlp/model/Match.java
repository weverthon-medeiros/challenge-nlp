package com.challenge.nlp.model;

public class Match {
	private Integer geonameid;
	private String name;
	private String covered_text;
	private Integer start;
	private Integer end;
	private Double score;

	public Match(Integer geonameid, String name, String covered_text, Integer start, Integer end, Double score) {
		this.geonameid = geonameid;
		this.name = name;
		this.covered_text = covered_text;
		this.start = start;
		this.end = end;
		this.score = score;
	}

	public Match(String covered_text, Integer start, Integer end) {
		this.covered_text = covered_text;
		this.start = start;
		this.end = end;
	}

	public Match() {
	}

	public Integer getGeonameid() {
		return geonameid;
	}

	public void setGeonameid(Integer geonameid) {
		this.geonameid = geonameid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCovered_text() {
		return covered_text;
	}

	public void setCovered_text(String covered_text) {
		this.covered_text = covered_text;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((covered_text == null) ? 0 : covered_text.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((geonameid == null) ? 0 : geonameid.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (covered_text == null) {
			if (other.covered_text != null)
				return false;
		} else if (!covered_text.equals(other.covered_text))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (geonameid == null) {
			if (other.geonameid != null)
				return false;
		} else if (!geonameid.equals(other.geonameid))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}

}
