package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;
import com.banking.service.AccountService;

@RestController
@RequestMapping("/api/acc")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/statusUpdate/{id}")
	public ResponseEntity<?> accountSatusUpdate(@PathVariable int id, @RequestParam String st) {
		return new ResponseEntity<>(accountService.accountStatusUpdate(id, st), HttpStatus.OK);
	}

	@GetMapping("/getAllPendigAccount")
	public ResponseEntity<?> getAllPendingAccount() {
		return new ResponseEntity<>(accountService.getAllAccount("Pending"), HttpStatus.OK);
	}

	@GetMapping("/getAllApproveAccount")
	public ResponseEntity<?> getAllApproveAccount() {
		return new ResponseEntity<>(accountService.getAllAccount("Approved"), HttpStatus.OK);
	}

	@GetMapping("/getAccountDetils")
	public ResponseEntity<?> getAccount(@RequestParam String accno) {

		UserDtls user = accountService.getDetailsByAccountNo(accno);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Account Number Invalid", HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAccountById/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable int id) {
		return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
	}
	

	@PostMapping("/doTransactionByAdmin")
	public ResponseEntity<?> doTransactionByAdmin(@RequestBody AccountTransaction trans) {
		return new ResponseEntity<>(accountService.doTransactionByAdmin(trans), HttpStatus.CREATED);
	}

	@GetMapping("/getTransaction")
	public ResponseEntity<?> getTransactionByAccount(@RequestParam String accno) {

		UserDtls user = accountService.getDetailsByAccountNo(accno);
		if (user != null) {
			return new ResponseEntity<>(accountService.getTransactionByAccount(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Account Number Invalid", HttpStatus.OK);
		}
	}
	@PostMapping("/updateAccount")
	public ResponseEntity<?> updateAccount(@RequestBody UserDtls user) {
		return new ResponseEntity<>(accountService.updateAccount(user), HttpStatus.OK);
	}
}
