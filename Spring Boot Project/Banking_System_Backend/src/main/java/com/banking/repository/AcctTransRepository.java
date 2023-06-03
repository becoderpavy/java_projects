package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;

public interface AcctTransRepository extends JpaRepository<AccountTransaction, Integer> {

	public List<AccountTransaction> findByUser(UserDtls user);

	
	
	
}
