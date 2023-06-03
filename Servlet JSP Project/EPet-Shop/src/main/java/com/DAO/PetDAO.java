package com.DAO;

import java.sql.Connection;
import java.util.List;

import com.entity.PetDtls;

public interface PetDAO {
	
	public boolean addPets(PetDtls p);
	
	public List<PetDtls> getPetsByShopId(int id);

	public PetDtls getPetsById(int pid,int sid);
	
	public List<PetDtls> getAllPets(String categorie);
	
	public PetDtls getPetsByIdUSer(int pid);

}
