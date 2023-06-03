package com.banking.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.AccountBalance;
import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;
import com.banking.exception.ResourceNotFoundException;
import com.banking.jwt.JwtProvider;
import com.banking.model.TransactionResponse;
import com.banking.repository.AcctBalanceRepository;
import com.banking.repository.AcctTransRepository;
import com.banking.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AcctTransRepository accTransRepo;

	@Autowired
	private AcctBalanceRepository acctBalRepo;

	@Autowired
	private JwtProvider jwtProvider;

	public UserDtls getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User JWT", "Token", userId));

		return user;
	}

	@Override
	public List<UserDtls> getAllAccount(String status) {
		return userRepo.findByRoleAndAccStatus("ROLE_USER", status);
	}

	@Override
	public String accountStatusUpdate(int id, String st) {

		Random rn = new Random();

		UserDtls user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

		if ("Approved".equals(st)) {
			user.setAccStatus("Approved");
			user.setAccountNum("102034" + rn.nextInt(1000));

			AccountTransaction trans = new AccountTransaction();
			trans.setUser(user);
			trans.setDate(LocalDate.now());
			trans.setTime(LocalTime.now());
			trans.setTransType("Credit");
			trans.setTransDtls("Account Opening");
			trans.setAmount(500.00);

			AccountBalance bal = new AccountBalance();
			bal.setTotalBalance(500.00);

			accTransRepo.save(trans);
			AccountBalance updatebal = acctBalRepo.save(bal);
			user.setAccBal(updatebal);
			user = userRepo.save(user);

			return "Account Approved successfully";
		} else if ("Reject".equals(st)) {
			userRepo.delete(user);
			return "Account Rejected";
		} else {
			return "Server error";
		}
	}

	@Override
	public String doTransactionByAdmin(AccountTransaction trans) {

		UserDtls user = userRepo.findByAccountNum(trans.getAccno());
		if (user == null) {
			return "invalid Account number";
		}

		AccountBalance accBalance = user.getAccBal();

		trans.setUser(user);

		if ("Debit".equals(trans.getTransType())) {
			if (trans.getAmount() > user.getAccBal().getTotalBalance()) {
				return "insufficent Balance";
			} else {
				trans.setTransDtls("Debit By Bank");
				trans.setDate(LocalDate.now());
				trans.setTime(LocalTime.now());

				accBalance.setTotalBalance(accBalance.getTotalBalance() - trans.getAmount());

				acctBalRepo.save(accBalance);
				accTransRepo.save(trans);

				return "Transaction success";
			}

		} else if ("Credit".equals(trans.getTransType())) {

			trans.setTransDtls("Deposit By Bank");
			trans.setDate(LocalDate.now());
			trans.setTime(LocalTime.now());

			accBalance.setTotalBalance(accBalance.getTotalBalance() + trans.getAmount());

			acctBalRepo.save(accBalance);
			accTransRepo.save(trans);

			return "Transaction success";
		} else {
			return "Choose Transaction Type";
		}
	}

	@Override
	public UserDtls getDetailsByAccountNo(String accountNo) {
		return userRepo.findByAccountNum(accountNo);
	}

	@Override
	public List<TransactionResponse> getTransactionByAccount(UserDtls user) {

		List<TransactionResponse> list = new ArrayList<TransactionResponse>();

		accTransRepo.findByUser(user).forEach((e) -> {

			TransactionResponse response = TransactionResponse.builder().transType(e.getTransType())
					.transDtls(e.getTransDtls()).amount(e.getAmount()).date(e.getDate()).time(e.getTime())
					.accountno(e.getUser().getAccountNum())
					.name(e.getUser().getFirstName() + "" + e.getUser().getLastName()).build();
			list.add(response);
		});
		return list;
	}

	@Override
	public String sendMoneyUser(UserDtls recevier, Double sendAmount, HttpServletRequest request) {

		UserDtls sender = getUserFromJwt(request);

		if (sendAmount > sender.getAccBal().getTotalBalance()) {
			return "insufficent Balance";
		} else {

			AccountTransaction trnsSender = new AccountTransaction();

			trnsSender.setTransDtls("send to acc no=" + recevier.getAccountNum());
			trnsSender.setDate(LocalDate.now());
			trnsSender.setTime(LocalTime.now());
			trnsSender.setAmount(sendAmount);
			trnsSender.setUser(sender);
			trnsSender.setTransType("Debit");

			AccountBalance sendBalance = sender.getAccBal();
			sendBalance.setTotalBalance(sender.getAccBal().getTotalBalance() - sendAmount);
			accTransRepo.save(trnsSender);
			acctBalRepo.save(sendBalance);

			AccountTransaction trnsRecever = new AccountTransaction();

			trnsRecever.setTransDtls("recive from acc no=" + sender.getAccountNum());
			trnsRecever.setDate(LocalDate.now());
			trnsRecever.setTime(LocalTime.now());
			trnsRecever.setAmount(sendAmount);
			trnsRecever.setUser(recevier);
			trnsRecever.setTransType("Credit");
			AccountBalance recBalance = recevier.getAccBal();
			recBalance.setTotalBalance(recevier.getAccBal().getTotalBalance() + sendAmount);
			accTransRepo.save(trnsRecever);
			acctBalRepo.save(recBalance);

			return "Money Send Success";
		}

	}

	@Override
	public UserDtls getAccountById(int id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@Override
	public UserDtls updateAccount(UserDtls user) {
		return userRepo.save(user);
	}

}
