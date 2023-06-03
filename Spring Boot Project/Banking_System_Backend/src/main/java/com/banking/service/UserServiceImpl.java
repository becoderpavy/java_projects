package com.banking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.config.CustomUserDetails;
import com.banking.entity.AccountTransaction;
import com.banking.entity.UserDtls;
import com.banking.exception.ResourceNotFoundException;
import com.banking.jwt.JwtProvider;
import com.banking.model.ChangePasswordRequest;
import com.banking.repository.AcctTransRepository;
import com.banking.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AcctTransRepository accTrnsRepo;

	public UserDtls getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User JWT", "Token", userId));

		return user;
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword("NA");
		user.setRole("ROLE_USER");
		user.setAccStatus("Pending");
		user.setAccountNum("NA");
		user.setUsername("NA");
		return userRepo.save(user);
	}

	@Override
	public UserDtls createEmp(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_EMP");
		user.setAccStatus("EMP_APPROVED");
		user.setAccountNum("NA");

		return userRepo.save(user);
	}

	@Override
	public UserDtls signInWithUserReturnJwt(UserDtls userDto) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));

		CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();

		String token = jwtProvider.generateToken(customUser);

		UserDtls user = customUser.getUser();
		user.setToken(token);

		return user;
	}

	@Override
	public UserDtls checkEmailAndMob(String email, String mob) {

		UserDtls user = userRepo.findByEmailAndMobNo(email, mob);
		if (user != null) {
			return user;
		}

		return null;
	}

	@Override
	public UserDtls resetPassword(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public UserDtls createNetbanking(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public boolean existUsername(String username) {
		return userRepo.existsByUsername(username);
	}

	@Override
	public List<UserDtls> getAllEmp() {
		return userRepo.findByRoleAndAccStatus("ROLE_EMP", "EMP_APPROVED");
	}

	@Override
	public List<AccountTransaction> getAllTransactionByUser(HttpServletRequest request) {
		UserDtls user = getUserFromJwt(request);
		return accTrnsRepo.findByUser(user);
	}

	@Override
	public boolean changePassword(ChangePasswordRequest passwordRequest, HttpServletRequest request) {

		UserDtls user = getUserFromJwt(request);

		if (passwordEncoder.matches(passwordRequest.getOldPassword(), user.getPassword())) {
			user.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
			userRepo.save(user);
			return true;
		}

		return false;
	}

}
