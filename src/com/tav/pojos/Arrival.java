package com.tav.pojos;

import java.sql.Date;
import java.sql.Time;

public class Arrival {
	public long id;
	private long airlineID;
	private String flightNo;
	private long originCity;
	private Date arrDate;
	private Time arrTime;
	
	public Arrival(long id,long airlineID, String flightNo, long originCity, Date arrDate, Time arrTime) {
		this.id = id;
		this.setAirlineID(airlineID);
		this.setFlightNo(flightNo);
		this.setOriginCity(originCity);
		this.setArrDate(arrDate);
		this.setArrTime(arrTime);
		
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public long getAirlineID() {
		return airlineID;
	}

	public void setAirlineID(long airlineID) {
		this.airlineID = airlineID;
	}

	public Date getArrDate() {
		return arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}

	public long getOriginCity() {
		return originCity;
	}

	public void setOriginCity(long originCity) {
		this.originCity = originCity;
	}
	
	@Override
	public String toString()
	{
		return airlineID+" "+flightNo;
	}

}