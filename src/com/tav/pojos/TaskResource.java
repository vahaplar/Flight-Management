package com.tav.pojos;

public class TaskResource {
	public long id;
	private long resourceID;
	private long taskID;

	public TaskResource(long id, long resourceID, long taskID) {
		this.id = id;
		this.resourceID = resourceID;
		this.taskID = taskID;

	}

	public long getID() {
		return this.id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public long getResourceID() {
		return this.resourceID;
	}

	public void setResourceID(long resourceID) {
		this.resourceID = resourceID;
	}

	public long getTaskID() {
		return this.taskID;
	}

	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}

}
