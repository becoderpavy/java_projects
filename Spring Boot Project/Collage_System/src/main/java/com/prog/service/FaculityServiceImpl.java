package com.prog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Collage;
import com.prog.entity.Department;
import com.prog.entity.Faculity;
import com.prog.exception.ResourceNotFoundException;
import com.prog.model.FaculityRequest;
import com.prog.model.FaculityResponse;
import com.prog.repository.CollageRepo;
import com.prog.repository.DepartmentRepo;
import com.prog.repository.FaculityRepo;

@Service
public class FaculityServiceImpl implements FaculityService {

	@Autowired
	private FaculityRepo faculityRepo;

	@Autowired
	private CollageRepo collageRepo;

	@Autowired
	private DepartmentRepo departRepo;

	@Override
	public int saveFaculity(FaculityRequest faculityRequest) {

		Collage collage = collageRepo.findById(faculityRequest.getCollageId())
				.orElseThrow(() -> new ResourceNotFoundException("Collage", "id", faculityRequest.getCollageId()));

		Department department = departRepo.findById(faculityRequest.getDepartmentId()).orElseThrow(
				() -> new ResourceNotFoundException("Department", "id", faculityRequest.getDepartmentId()));

		Faculity faculity = Faculity.builder().faculityName(faculityRequest.getFaculityName()).collage(collage)
				.department(department).build();

		return faculityRepo.save(faculity).getId();
	}

	@Override
	public List<FaculityResponse> getFaculityByCollage(String collageName) {

		Collage c = collageRepo.findByCollageName(collageName);

		List<Faculity> faculity = faculityRepo.findByCollage(c);

		List<FaculityResponse> faculityResponses = new ArrayList<FaculityResponse>();

		faculity.forEach(e -> {

			faculityResponses.add(new FaculityResponse().builder().id(e.getId()).faculityName(e.getFaculityName())
					.collageName(e.getCollage().getCollageName()).departmentName(e.getDepartment().getDepartmentName())
					.build());

		});

		return faculityResponses;
	}

	@Override
	public List<FaculityResponse> getFaculityByDepartment(String departmentName) {

		Department depart = departRepo.findByDepartmentName(departmentName);

		List<Faculity> faculity = faculityRepo.findByDepartment(depart);

		List<FaculityResponse> faculityResponses = new ArrayList<FaculityResponse>();

		faculity.forEach(e -> {

			faculityResponses.add(new FaculityResponse().builder().id(e.getId()).faculityName(e.getFaculityName())
					.collageName(e.getCollage().getCollageName()).departmentName(e.getDepartment().getDepartmentName())
					.build());

		});

		return faculityResponses;
	}

}
