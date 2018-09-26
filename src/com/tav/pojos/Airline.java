package com.tav.pojos;

public class Airline {
	public long id;
	private String airlineCode;
	private String airlineName;
	

	public Airline(long id, String airlineCode, String airlineName) {
		this.id = id;
		this.airlineCode = airlineCode;
		this.airlineName = airlineName;

	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getAirlineCode() {
		return this.airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	
	@Override
	public String toString()
	{
		return airlineName;
	}

}
