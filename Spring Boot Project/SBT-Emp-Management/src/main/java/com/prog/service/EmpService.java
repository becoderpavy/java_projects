package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prog.entity.Emp;
import com.prog.repo.EmpRepo;

@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;

	public void addEmp(Emp e) {
		 repo.save(e);
	}

	public List<Emp> getAllEmp() {
		return repo.findAll();
		 
	}
	
	public Page<Emp> getPageEmp(int page,int totalSize)
	{
		Pageable p=PageRequest.of(page, totalSize);
		return repo.findAll(p);
	}

	public Emp getEmpById(int id) {
		Optional<Emp> op = repo.findById(id);
		Emp e = null;
		if (op.isPresent()) {
			e = op.get();
		}
		return e;
	}
	
	public void deleteEmpByID(int id)
	{
		repo.deleteById(id);
	}
	

}
