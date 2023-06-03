package com.entites;

public class Resume {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String dob;
	private String gender;
	private String maritalStatus;
	private String phoneNumber;
	private String email;

	private String qualification;
	private String institute;
	private String yearOfGraduation;

	private String previousEmployer;
	private String previousDesignation;
	private String currentEmployer;
	private String currentDesignation;

	private String totalExperience;
	private String skill;

	private int userId;
	private String resumeFileName;

	public Resume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resume(String firstName, String middleName, String lastName, String address, String dob, String gender,
			String maritalStatus, String phoneNumber, String email, String qualification, String institute,
			String yearOfGraduation, String previousEmployer, String previousDesignation, String currentEmployer,
			String currentDesignation, String totalExperience, String skill, int userId, String resumeFileName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.qualification = qualification;
		this.institute = institute;
		this.yearOfGraduation = yearOfGraduation;
		this.previousEmployer = previousEmployer;
		this.previousDesignation = previousDesignation;
		this.currentEmployer = currentEmployer;
		this.currentDesignation = currentDesignation;
		this.totalExperience = totalExperience;
		this.skill = skill;
		this.userId = userId;
		this.resumeFileName = resumeFileName;
	}

	public Resume(int id, String firstName, String middleName, String lastName, String address, String dob,
			String gender, String maritalStatus, String phoneNumber, String email, String qualification,
			String institute, String yearOfGraduation, String previousEmployer, String previousDesignation,
			String currentEmployer, String currentDesignation, String totalExperience, String skill, int userId,
			String resumeFileName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.dob = dob;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.qualification = qualification;
		this.institute = institute;
		this.yearOfGraduation = yearOfGraduation;
		this.previousEmployer = previousEmployer;
		this.previousDesignation = previousDesignation;
		this.currentEmployer = currentEmployer;
		this.currentDesignation = currentDesignation;
		this.totalExperience = totalExperience;
		this.skill = skill;
		this.userId = userId;
		this.resumeFileName = resumeFileName;
	}

	public String getResumeFileName() {
		return resumeFileName;
	}

	public void setResumeFileName(String resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(String yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public String getPreviousEmployer() {
		return previousEmployer;
	}

	public void setPreviousEmployer(String previousEmployer) {
		this.previousEmployer = previousEmployer;
	}

	public String getPreviousDesignation() {
		return previousDesignation;
	}

	public void setPreviousDesignation(String previousDesignation) {
		this.previousDesignation = previousDesignation;
	}

	public String getCurrentEmployer() {
		return currentEmployer;
	}

	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
