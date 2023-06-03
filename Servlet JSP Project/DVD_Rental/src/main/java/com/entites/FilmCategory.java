package com.entites;

public class FilmCategory {

	private int filmId;

	private int categoryId;

	public FilmCategory(int filmId, int categoryId) {
		super();
		this.filmId = filmId;
		this.categoryId = categoryId;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public FilmCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
