package com.tav.pojos;

import java.sql.Date;
import java.sql.Time;

public class Departure {
	public long id;
	private long airlineID;
	private String flightNo;
	private long destinationCity;
	private Date depDate;
	private Time depTime;

	public Departure(long id,long airlineID, String flightNo, long destinationCity, Date depDate, Time depTime) {
		this.id = id;
		this.setAirlineID(airlineID);
		this.setFlightNo(flightNo);
		this.setDestinationCity(destinationCity);
		this.setDepDate(depDate);
		this.setDepTime(depTime);
		
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(long airlineID) {
		this.airlineID = airlineID;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public long getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(long destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Date getDepDate() {
		return depDate;
	}

	public void setDepDate(Date depDate) {
		this.depDate = depDate;
	}

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}
	
	@Override
	public String toString()
	{
		return airlineID+" "+flightNo;
	}
}
