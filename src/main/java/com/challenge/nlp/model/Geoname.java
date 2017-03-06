package com.challenge.nlp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "geoname")
public class Geoname {

	@Id
	private Integer geonameid;
	private String name;
	private String asciiname;

	public Geoname(Integer geonameid, String name, String asciiname) {
		this.geonameid = geonameid;
		this.name = name;
		this.asciiname = asciiname;
	}

	public Geoname() {
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

	public String getAsciiname() {
		return asciiname;
	}

	public void setAsciiname(String asciiname) {
		this.asciiname = asciiname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geonameid == null) ? 0 : geonameid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Geoname other = (Geoname) obj;
		if (geonameid == null) {
			if (other.geonameid != null)
				return false;
		} else if (!geonameid.equals(other.geonameid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
