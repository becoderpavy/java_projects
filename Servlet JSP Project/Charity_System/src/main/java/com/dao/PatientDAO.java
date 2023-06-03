package com.dao;

import java.util.List;

import com.entity.Patient;

public interface PatientDAO {

	public boolean addPatient(Patient p);

	public List<Patient> getAllPatient();

	public List<Patient> getAllPatientByOrg(int oid);

	public boolean updatePatient(String st, int id);

	public Patient getPatientById(int id);
	
	public boolean deletePatient(int id);
	
	public boolean updateAmount(Double amt,int id);

}
