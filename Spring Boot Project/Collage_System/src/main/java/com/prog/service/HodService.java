package com.prog.service;

import com.prog.entity.HOD;
import com.prog.model.HodRequest;
import com.prog.model.HodResponse;

public interface HodService {

	public String assignDepartment(HodRequest hodRequest);

	public HodResponse getHodByDepartment(String departmentName);

	public boolean existCollageAndHodNameAndDepartment(HOD h);

}
