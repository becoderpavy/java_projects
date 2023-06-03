package com.prog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Collage;
import com.prog.entity.Department;
import com.prog.entity.HOD;
import com.prog.exception.ResourceNotFoundException;
import com.prog.model.HodRequest;
import com.prog.model.HodResponse;
import com.prog.repository.CollageRepo;
import com.prog.repository.DepartmentRepo;
import com.prog.repository.HODRepo;

@Service
public class HodServiceImpl implements HodService {

	@Autowired
	private HODRepo hodRepo;

	@Autowired
	private CollageRepo collageRepo;

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public String assignDepartment(HodRequest hodRequest) {

		Collage collage = collageRepo.findById(hodRequest.getCollageId())
				.orElseThrow(() -> new ResourceNotFoundException("Collage", "id", hodRequest.getCollageId()));

		Department department = departmentRepo.findById(hodRequest.getDepartmentId())
				.orElseThrow(() -> new ResourceNotFoundException("Department", "id", hodRequest.getDepartmentId()));

		HOD hod = HOD.builder().hodName(hodRequest.getHodName()).collage(collage).department(department).build();

		if (existCollageAndHodNameAndDepartment(hod)) {
			return "Alreday Assign";
		}

		else {
			hodRepo.save(hod);

			return "Hod Assign Sucessfully";
		}

	}

	@Override
	public HodResponse getHodByDepartment(String departmentName) {

		Department depart = departmentRepo.findByDepartmentName(departmentName);

		if (depart != null)

		{
			HOD hod = hodRepo.findByDepartment(depart);

			HodResponse hodResponse = HodResponse.builder().id(hod.getId()).hodName(hod.getHodName())
					.collageName(hod.getCollage().getCollageName())
					.departmentName(hod.getDepartment().getDepartmentName()).build();
			return hodResponse;

		}

		return null;

	}

	@Override
	public boolean existCollageAndHodNameAndDepartment(HOD h) {

		return hodRepo.existsByCollageAndHodNameAndDepartment(h.getCollage(), h.getHodName(), h.getDepartment());
	}

}
