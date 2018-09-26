package com.tav.pojos;

public class UserRole {
	public long id;
	private long userID;
	private long roleID;

	public UserRole(long id, long userID, long roleID) {
		this.id = id;
		this.userID = userID;
		this.roleID = roleID;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

}
