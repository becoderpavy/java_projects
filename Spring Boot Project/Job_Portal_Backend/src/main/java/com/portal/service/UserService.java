package com.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.portal.entity.Candidates;
import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;

public interface UserService {

	public UserDtls createUser(UserDtls user);

	public boolean checkEmail(String email);

	UserDtls signInWithUserReturnJwt(UserDtls userDto);

	UserDtls checkEmailAndMob(String email, String mob);

	UserDtls resetPassword(UserDtls user);

	public Candidates applyJob(Candidates candidates, MultipartFile file, HttpServletRequest request);

	public List<Candidates> getAppliedJob(HttpServletRequest request);

	public List<Jobs> getAllJobs();

	public boolean checkAppliedJob(int userId, int jobId);

	public List<Jobs> searchJob(String ch);

	public UserDtls updateProfile(UserDtls user);

	public List<UserDtls> getAllUser();

	public List<UserDtls> getAllRecruiter();
}
