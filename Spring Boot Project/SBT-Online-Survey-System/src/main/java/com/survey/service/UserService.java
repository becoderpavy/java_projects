package com.survey.service;

import java.util.List;

import com.survey.entity.Survey;
import com.survey.entity.UserDtls;
import com.survey.helper.UserDtlsResponse;

public interface UserService {
	
	UserDtls createUser(UserDtls userDtls);
	
	boolean checkEmail(String email);
	
	UserDtlsResponse getAllUser(int pageNo);
	
	 long getUserNo();
	
	

}
