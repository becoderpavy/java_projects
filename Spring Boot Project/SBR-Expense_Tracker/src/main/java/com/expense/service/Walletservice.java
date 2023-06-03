package com.expense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entites.Wallet;
import com.expense.exception.WalletException;
import com.expense.repository.WalletRepo;

@Service
public class Walletservice {

	@Autowired
	private WalletRepo walletRepo;
	
	public List<Wallet> getAll(){
		return walletRepo.findAllByOrderByPriority();
	}
	
	
	public Wallet getById(Long id) {
		Optional<Wallet> wallet = walletRepo.findById(id);

		if (wallet.isPresent()) {
			return wallet.get();
		}
		throw new WalletException("Wallet with " + id + " doesnot exsit");
	}
	

	public Wallet createOrUpdate(Wallet wallet) {

		if (wallet.getId() == null) {
			walletRepo.save(wallet);
		} else {
			walletRepo.save(wallet);
		}
		return wallet;
	}

	public boolean delete(Long id) {
		Optional<Wallet> wallet = walletRepo.findById(id);

		if (wallet.isPresent()) {
			walletRepo.delete(wallet.get());
			return true;
		}
		throw new WalletException("Wallet with " + id + " doesnot exsit");
	}

}
