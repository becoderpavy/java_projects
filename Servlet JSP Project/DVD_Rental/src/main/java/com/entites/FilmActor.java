package com.entites;

public class FilmActor {

	private int actorId;

	private int filmId;

	public FilmActor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public FilmActor(int actorId, int filmId) {
		super();
		this.actorId = actorId;
		this.filmId = filmId;
	}

}
