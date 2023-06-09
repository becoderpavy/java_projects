package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {

	public boolean existsByEmail(String email);

	public List<Emp> findByRoleOrderByIdDesc(String role);

	public Emp findByEmail(String email);

	public long countByRole(String role);
	
	public Emp findByEmailAndMobNo(String email,String mobNo);
	
	public Emp findByEmpId(String empid);
	
	
}
