package com.prog.service;

import java.util.List;

import com.prog.model.FaculityRequest;
import com.prog.model.FaculityResponse;

public interface FaculityService {

	public int saveFaculity(FaculityRequest faculityRequest);

	public List<FaculityResponse> getFaculityByCollage(String collageName);

	public List<FaculityResponse> getFaculityByDepartment(String departmentName);

}
