package com.becoder.exception;

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

	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
