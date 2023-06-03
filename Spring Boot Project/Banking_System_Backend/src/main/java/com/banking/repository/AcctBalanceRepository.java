package com.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.AccountBalance;
import com.banking.entity.UserDtls;

public interface AcctBalanceRepository extends JpaRepository<AccountBalance, Integer> {

}
