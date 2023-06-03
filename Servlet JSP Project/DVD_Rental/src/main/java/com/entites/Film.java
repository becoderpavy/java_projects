package com.entites;

public class Film {

	private int filmId;

	private String title;

	private String description;

	private String relaseYear;

	private int languageId;

	private int length;

	private String rating;

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(int filmId, String title, String description, String relaseYear, int languageId, int length,
			String rating) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.relaseYear = relaseYear;
		this.languageId = languageId;
		this.length = length;
		this.rating = rating;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRelaseYear() {
		return relaseYear;
	}

	public void setRelaseYear(String relaseYear) {
		this.relaseYear = relaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
