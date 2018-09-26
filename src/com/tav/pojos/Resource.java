package com.tav.pojos;

public class Resource {
	public long id;
	private String resourceCode;
	private String description;
	private String resourceType;

	public Resource(long id, String resourceCode,String description, String resourceType) {
		this.id = id;
		this.resourceCode = resourceCode;
		this.description = description;
		this.resourceType = resourceType;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getResourceCode() {
		return this.resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	
	@Override
	public String toString()
	{
		return resourceType;
	}


}
