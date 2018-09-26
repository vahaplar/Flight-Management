package com.tav.pojos;

public class City {
	public long id;
	private String cityCode;
	private String cityName;

	public City(long id, String cityCode, String cityName) {
		this.id = id;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@Override
	public String toString()
	{
		return cityName;
	}

}
