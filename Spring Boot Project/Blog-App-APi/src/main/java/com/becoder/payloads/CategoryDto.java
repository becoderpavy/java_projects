package com.becoder.payloads;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CategoryDto {
	private Integer id;

	@NotEmpty
	private String categoryTitle;

	@NotEmpty
	private String categoryDescription;
}
