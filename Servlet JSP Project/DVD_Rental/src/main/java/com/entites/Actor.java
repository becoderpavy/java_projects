package com.entites;

public class Actor {

	private int actorId;
	private String firstName;
	private String lastName;
	private String lastupdate;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(int actorId, String firstName, String lastName, String lastupdate) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastupdate = lastupdate;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

}
