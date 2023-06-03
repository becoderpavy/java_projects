package com.expense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.entites.Wallet;

public interface WalletRepo extends JpaRepository<Wallet, Long>{

	List<Wallet> findAllByOrderByPriority();
}
