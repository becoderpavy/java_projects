package com.ebook.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryDto {

	private Integer id;

	@NotEmpty
	private String categoryName;

	@NotEmpty
	private String description;

	// private List<Books> book = new ArrayList<Books>();

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer id, @NotEmpty String categoryName, @NotEmpty String description) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
