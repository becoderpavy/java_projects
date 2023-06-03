package com.expense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.entites.Wallet;
import com.expense.repository.WalletRepo;
import com.expense.service.ValidationErrorService;
import com.expense.service.Walletservice;

@RestController
@RequestMapping("/wallet/")
public class WalletController {

	@Autowired
	private Walletservice walletservice;
	
	@Autowired
	private ValidationErrorService validationService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(walletservice.getAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		return new ResponseEntity<>(walletservice.getById(id),HttpStatus.OK);
	}
	


	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result) {

		ResponseEntity errors = validationService.validate(result);

		if (errors != null) {
			return errors;
		}
		Wallet saveWallet = walletservice.createOrUpdate(wallet);

		return new ResponseEntity<Wallet>(saveWallet, HttpStatus.CREATED);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody Wallet wallet, BindingResult result) {

		ResponseEntity errors = validationService.validate(result);

		if (errors != null) {
			return errors;
		}
		wallet.setId(id);
		Wallet saveWallet = walletservice.createOrUpdate(wallet);

		return new ResponseEntity<Wallet>(saveWallet, HttpStatus.CREATED);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		walletservice.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
