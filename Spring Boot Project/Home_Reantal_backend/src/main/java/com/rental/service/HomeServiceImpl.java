package com.rental.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rental.entites.Home;
import com.rental.entites.Role;
import com.rental.entites.UserDtls;
import com.rental.exception.ResourceNotFoundException;
import com.rental.jwt.JwtProvider;
import com.rental.repository.HomeRepository;
import com.rental.repository.RoleRepository;
import com.rental.repository.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FileService fileService;

	@Autowired
	private RoleRepository roleRepo;

	@Value("${project.image}")
	private String path;

	@Autowired
	private HomeRepository homeRepo;

	public int getUserFromJwt(HttpServletRequest request) {
		Claims claim = jwtProvider.extractClaims(request);
		int userId = claim.get("userId", Integer.class);

		return userId;
	}

	@Override
	public Home createHome(Home home, MultipartFile file, HttpServletRequest request) {

		int uid = getUserFromJwt(request);
		UserDtls user = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("Seller", "token is invalid with", uid));

		home.setSeller(user);

		if (!file.isEmpty()) {
			home.setImage(file.getOriginalFilename());
		} else {
			home.setImage("default.jpg");
		}

		Home newHome = homeRepo.save(home);
		if (newHome != null) {
			try {
				fileService.uploadImage(path, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return newHome;
	}

	@Override
	public List<Home> getAllHome() {

		return homeRepo.findAll();
	}

	@Override
	public List<Home> getAllHomeByUser(HttpServletRequest request) {

		int uid = getUserFromJwt(request);
		UserDtls user = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token is invalid", uid));

		return homeRepo.findBySeller(user);
	}

	@Override
	public Home updateHome(HttpServletRequest request, Home home, MultipartFile file) {

		int uid = getUserFromJwt(request);
		UserDtls user = userRepo.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "token is invalid", uid));

		home.setSeller(user);
		Home oldHome = homeRepo.findById(home.getId()).get();

		if (file == null) {

			home.setImage(oldHome.getImage());
		} else {

			home.setImage(file.getOriginalFilename());
		}

		Home updateHome = homeRepo.save(home);

		if (updateHome != null) {
			if (file != null) {
				try {
					fileService.uploadImage(path, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return updateHome;
	}

	@Override
	public void deleteHome(Integer id) {

		Home home = homeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Home", "Id", id));
		homeRepo.delete(home);
	}

	@Override
	public Home getHomeById(Integer id) {
		return homeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Home", "Id", id));

	}

	@Override
	public UserDtls updateProfile(UserDtls user) {
		return userRepo.save(user);
	}

	@Override
	public List<UserDtls> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(Integer id) {
		UserDtls user = userRepo.findById(id).get();

		if (user != null) {

//			for (Role r : user.getRole()) {
//				Role ro = roleRepo.findById(r.getId()).get();
//				roleRepo.delete(ro);
//			}

			userRepo.delete(user);
		}
	}

	@Override
	public List<Home> searchHome(String ch) {
		return homeRepo.search(ch);
	}

}
