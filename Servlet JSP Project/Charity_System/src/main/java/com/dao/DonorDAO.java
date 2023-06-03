package com.dao;

import com.entity.Donor;

public interface DonorDAO {

	public boolean addDonor(Donor d);

	public Donor login(String em, String ps);

}
