package com.banking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.UserDtls;
import com.banking.model.ChangePasswordRequest;
import com.banking.model.NetBankingRequest;
import com.banking.model.SendMoneyRequest;
import com.banking.service.AccountService;
import com.banking.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserDtls user) {

		if (userService.checkEmail(user.getEmail())) {
			return new ResponseEntity<>("Email id already Exist", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
		}
	}

	@PostMapping("/registerEmp")
	public ResponseEntity<?> createEmp(@RequestBody UserDtls user) {

		if (userService.checkEmail(user.getEmail())) {
			return new ResponseEntity<>("Email id already Exist", HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<>(userService.createEmp(user), HttpStatus.CREATED);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDtls userDtls) {
		return new ResponseEntity<>(userService.signInWithUserReturnJwt(userDtls), HttpStatus.OK);
	}

	@GetMapping("/forgotPassword/{em}/{no}")
	public ResponseEntity<?> checkEmailAndMob(@PathVariable String em, @PathVariable String no) {
		return new ResponseEntity<>(userService.checkEmailAndMob(em, no), HttpStatus.OK);
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<?> updatePassword(@RequestBody UserDtls user) {
		return new ResponseEntity<>(userService.resetPassword(user), HttpStatus.OK);
	}

	@PostMapping("/createNetbanking")
	public ResponseEntity<?> createNetbanking(@RequestBody NetBankingRequest request) {

		UserDtls user = accountService.getDetailsByAccountNo(request.getAccno());

		if (user != null) {

			if (userService.existUsername(request.getUsername())) {
				return new ResponseEntity<>("username already exist", HttpStatus.CONFLICT);
			} else {
				user.setUsername(request.getUsername());
				user.setPassword(request.getPassword());
				return new ResponseEntity<>(userService.createNetbanking(user), HttpStatus.CREATED);
			}
		} else {
			return new ResponseEntity<>("Account Number Invalid", HttpStatus.CONFLICT);
		}

	}

	@PostMapping("/sendMoney")
	public ResponseEntity<?> userSendMoney(@RequestBody SendMoneyRequest m, HttpServletRequest request) {

		UserDtls reciver = accountService.getDetailsByAccountNo(m.getSenderAccountNo());

		if (reciver != null) {
			return new ResponseEntity<>(accountService.sendMoneyUser(reciver, m.getAmount(), request), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Sender Account Number Invalid", HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/getAllEmp")
	public ResponseEntity<?> getAllEmp() {
		return new ResponseEntity<>(userService.getAllEmp(), HttpStatus.OK);
	}

	@GetMapping("/getAllTrans")
	public ResponseEntity<?> getAllTrans(HttpServletRequest request) {
		return new ResponseEntity<>(userService.getAllTransactionByUser(request), HttpStatus.OK);
	}

	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePsw, HttpServletRequest request) {

		if (userService.changePassword(changePsw, request)) {
			return new ResponseEntity<>("Password Change Sucessfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("old password is incorrect", HttpStatus.CONFLICT);
		}

	}
}
