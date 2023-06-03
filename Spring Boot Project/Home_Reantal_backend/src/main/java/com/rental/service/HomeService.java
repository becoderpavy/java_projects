package com.rental.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.rental.entites.Home;
import com.rental.entites.UserDtls;

public interface HomeService {

	public Home createHome(Home home, MultipartFile file, HttpServletRequest request);

	public Home getHomeById(Integer id);

	public List<Home> getAllHome();

	public List<Home> getAllHomeByUser(HttpServletRequest request);

	public Home updateHome(HttpServletRequest request, Home home, MultipartFile file);

	public void deleteHome(Integer id);

	public UserDtls updateProfile(UserDtls user);

	public List<UserDtls> getAllUser();

	public void deleteUser(Integer id);

	public List<Home> searchHome(String ch);

}
