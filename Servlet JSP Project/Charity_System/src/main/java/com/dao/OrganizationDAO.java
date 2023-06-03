package com.dao;

import java.util.List;

import com.entity.Organization;

public interface OrganizationDAO {

	public boolean addOrg(Organization o);

	public Organization login(String em, String ps);

	public List<Organization> getAllOrg();
	
	public Organization getOrgById(int id);

}
