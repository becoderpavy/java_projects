package com.portal.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.portal.config.CustomUserDetails;
import com.portal.entity.Candidates;
import com.portal.entity.Jobs;
import com.portal.entity.Role;
import com.portal.entity.UserDtls;
import com.portal.exception.ResourceNotFoundException;
import com.portal.jwt.JwtProvider;
import com.portal.repository.CandidateRepository;
import com.portal.repository.JobRepository;
import com.portal.repository.RoleRepository;
import com.portal.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CandidateRepository candidateRepo;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private FileService fileService;

	@Value("${project.resume}")
	private String path;

	public UserDtls getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);

		int userId = claim.get("userId", Integer.class);
		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "token is invalid with", userId));
		return user;
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public UserDtls createUser(UserDtls user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role role = roleRepo.findById(user.getRoleId())
				.orElseThrow(() -> new ResourceNotFoundException("Role", "invalid with id=", user.getRoleId()));

		user.getRole().add(role);

		if ("ROLE_USER".equals(role.getRole())) {
			user.setCompanyName("NA");
		} else {
			user.setExperience("NA");
			user.setSkill("NA");
		}

		return userRepo.save(user);
	}

	@Override
	public UserDtls signInWithUserReturnJwt(UserDtls userDto) {

		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
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
	public Candidates applyJob(Candidates candidates,MultipartFile file, HttpServletRequest request) {

		UserDtls user = userRepo.findById(candidates.getUserId())
			.orElseThrow(() -> new ResourceNotFoundException("user", "id", candidates.getRecruiterId()));

		Jobs job = jobRepository.findById(candidates.getJobId())
				.orElseThrow(() -> new ResourceNotFoundException("job", "id", candidates.getJobId()));

		//UserDtls user = getUserFromJwt(request);

		candidates.setRecruiter(job.getRecruiter());
		candidates.setUser(user);
		candidates.setJob(job);

		if (!file.isEmpty()) {
			candidates.setResume(file.getOriginalFilename());
		}
		Candidates can = candidateRepo.save(candidates);

		if (can != null) {
			try {
				fileService.uploadImage(path, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return can;
	}

	@Override
	public List<Candidates> getAppliedJob(HttpServletRequest request) {

		UserDtls user = getUserFromJwt(request);
		return candidateRepo.findByUser(user);
	}

	@Override
	public List<Jobs> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public boolean checkAppliedJob(int userId, int jobId) {

		UserDtls user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id=", userId));

		Jobs job = jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job", "id=", jobId));

		return candidateRepo.existsByUserAndJob(user, job);
	}

	@Override
	public List<Jobs> searchJob(String ch) {
		return jobRepository.search(ch);
	}

	@Override
	public UserDtls updateProfile(UserDtls user) {
		return userRepo.save(user);
	}

	@Override
	public List<UserDtls> getAllUser() {

		Role role = roleRepo.findById(102)
				.orElseThrow(() -> new ResourceNotFoundException("Role", "invalid with id=", 102));

		return userRepo.findByRole(role);
	}

	@Override
	public List<UserDtls> getAllRecruiter() {
		Role role = roleRepo.findById(103)
				.orElseThrow(() -> new ResourceNotFoundException("Role", "invalid with id=", 103));

		return userRepo.findByRole(role);
	}

}
