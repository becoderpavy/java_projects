package com.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.survey.entity.Survey;
import com.survey.entity.UserDtls;
import com.survey.helper.UserDtlsResponse;
import com.survey.repository.SurveyRepository;
import com.survey.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	

	@Override
	public boolean checkEmail(String email) {
		UserDtls user = userRepository.findByEmail(email);
		if (user == null)
			return true;
		else
			return false;
	}

	@Override
	public UserDtls createUser(UserDtls userDtls) {
		return userRepository.save(userDtls);
	}

	@Override
	public UserDtlsResponse getAllUser(int pageNo) {

		Pageable pageable = PageRequest.of(pageNo, 5);

		Page<UserDtls> page = userRepository.findAll(pageable);
		List<UserDtls> content = page.getContent();

		UserDtlsResponse response = new UserDtlsResponse();
		response.setUser(content);
		response.setPageNo(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElement(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());

		return response;
	}
	
	public long getUserNo()
	{
		return userRepository.count();
	}

	

}
