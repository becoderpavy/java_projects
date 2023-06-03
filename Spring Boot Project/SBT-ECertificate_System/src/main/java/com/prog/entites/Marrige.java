package com.prog.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marrige {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String boyName;

	private String dobBoy;

	private int boyAge;

	private String boyAddress;

	private String girlName;

	private String dobGirl;

	private int girlAge;

	private String girlAddress;

	private String marrigeDate;

	private String proofDocument;

	private String status;

	private long userId;
	
	private String certificateName;

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBoyName() {
		return boyName;
	}

	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

	public String getDobBoy() {
		return dobBoy;
	}

	public void setDobBoy(String dobBoy) {
		this.dobBoy = dobBoy;
	}

	public String getDobGirl() {
		return dobGirl;
	}

	public void setDobGirl(String dobGirl) {
		this.dobGirl = dobGirl;
	}

	public int getBoyAge() {
		return boyAge;
	}

	public void setBoyAge(int boyAge) {
		this.boyAge = boyAge;
	}

	public String getMarrigeDate() {
		return marrigeDate;
	}

	public void setMarrigeDate(String marrigeDate) {
		this.marrigeDate = marrigeDate;
	}

	public String getBoyAddress() {
		return boyAddress;
	}

	public void setBoyAddress(String boyAddress) {
		this.boyAddress = boyAddress;
	}

	public String getGirlAddress() {
		return girlAddress;
	}

	public void setGirlAddress(String girlAddress) {
		this.girlAddress = girlAddress;
	}

	public String getProofDocument() {
		return proofDocument;
	}

	public void setProofDocument(String proofDocument) {
		this.proofDocument = proofDocument;
	}

	public int getGirlAge() {
		return girlAge;
	}

	public void setGirlAge(int girlAge) {
		this.girlAge = girlAge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
