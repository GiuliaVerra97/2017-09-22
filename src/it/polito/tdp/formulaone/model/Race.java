package it.polito.tdp.formulaone.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

public class Race {
	
	private int raceId ;
	private int year ;
	private int round ;
	private int circuitId ; // refers to {@link Circuit}
	private String name ;
	private LocalDate date ;
	private LocalTime time ;
	private String url ;
	public Race(int raceId, int year, int round, int circuitId, String name, LocalDate date, LocalTime time,
			String url) {
		super();
		this.raceId = raceId;
		this.year = year;
		this.round = round;
		this.circuitId = circuitId;
		this.name = name;
		this.date = date;
		this.time = time;
		this.url = url;
	}
	public int getRaceId() {
		return raceId;
	}
	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getCircuitId() {
		return circuitId;
	}
	public void setCircuitId(int circuitId) {
		this.circuitId = circuitId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return String.format("Race [name=%s]", name);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + circuitId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + raceId;
		result = prime * result + round;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + year;
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
		Race other = (Race) obj;
		if (circuitId != other.circuitId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (raceId != other.raceId)
			return false;
		if (round != other.round)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	

}
