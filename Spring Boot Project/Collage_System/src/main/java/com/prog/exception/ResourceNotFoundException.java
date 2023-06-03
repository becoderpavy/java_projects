package com.prog.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	private String resourceName;

	private String fieldName;

	private Integer value;

	public ResourceNotFoundException(String resourceName, String fieldName, Integer value) {
		super(String.format("%s not found with %s :%s", resourceName, fieldName, value));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}
	

}
