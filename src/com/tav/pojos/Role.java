package com.tav.pojos;

public class Role {
	public long id;
	private String roleCode;
	private String description;

	public Role(long id, String roleCode, String description) {
		this.id = id;
		this.roleCode = roleCode;
		this.description = description;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void getRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return roleCode;
	}


}
