package com.tav.pojos;

public class Task {
	public long id;
	private long arrID;
	private long depID;

	public Task(long id, long arrID, long depID) {
		this.id = id;
		this.arrID = arrID;
		this.depID = depID;
	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getArrID() {
		return this.arrID;
	}

	public void setArrID(long arrID) {
		this.arrID = arrID;
	}

	public long getDepID() {
		return this.depID;
	}

	public void setDepID(long depID) {
		this.depID = depID;
	}

}
