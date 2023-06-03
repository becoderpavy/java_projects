package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prog.entity.Collage;
import com.prog.entity.Department;
import com.prog.exception.ResourceNotFoundException;
import com.prog.model.DepartmentRequest;
import com.prog.repository.CollageRepo;
import com.prog.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Autowired
	private CollageRepo collageRepo;

	@Override
	public String saveDepartment(DepartmentRequest depReq) {
		// System.out.println(dep.getCollage().getId());

		Collage collage=collageRepo.findById(depReq.getCollageId())
				.orElseThrow(() -> new ResourceNotFoundException("Collage", "Id", depReq.getCollageId()));

		Department department=Department.builder().
				departmentName(depReq.getDepartmentName())
				.collage(collage)
				.build();
		
		if (existDepartment(depReq.getDepartmentName())) {
			return "Department Alreday Exist";
		}

		if (departmentRepo.save(department) != null) {
			return "Department Saved Sucessfully";
		}
		return "Error";
	}

	@Override
	public List<Department> getDepartmentByCollageName(String name) {
		Collage c = collageRepo.findByCollageName(name);

		return departmentRepo.findByCollage(c);
	}

	@Override
	public boolean existDepartment(String departmentName) {
		return departmentRepo.existsByDepartmentName(departmentName);
	}

}
