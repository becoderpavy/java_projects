package com.entites;

public class Job {

	private long id;
	private String jobName;
	private String description;
	private String experience;
	private String skill;
	private String qualification;
	private String location;
	private String salary;
	private String vacancies;
	private String empName;
	private String contactNumber;
	private String email;
	private String address;
	private String publishDate;

	public Job(String jobName, String description, String experience, String skill, String qualification,
			String location, String salary, String vacancies, String empName, String contactNumber, String email,
			String address, String publishDate) {
		super();
		this.jobName = jobName;
		this.description = description;
		this.experience = experience;
		this.skill = skill;
		this.qualification = qualification;
		this.location = location;
		this.salary = salary;
		this.vacancies = vacancies;
		this.empName = empName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.publishDate = publishDate;
	}

	public Job(long id, String jobName, String description, String experience, String skill, String qualification,
			String location, String salary, String vacancies, String empName, String contactNumber, String email,
			String address, String publishDate) {
		super();
		this.id = id;
		this.jobName = jobName;
		this.description = description;
		this.experience = experience;
		this.skill = skill;
		this.qualification = qualification;
		this.location = location;
		this.salary = salary;
		this.vacancies = vacancies;
		this.empName = empName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.publishDate = publishDate;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getVacancies() {
		return vacancies;
	}

	public void setVacancies(String vacancies) {
		this.vacancies = vacancies;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

}
