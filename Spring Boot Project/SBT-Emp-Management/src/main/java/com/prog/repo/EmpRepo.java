package com.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer>{
	


}
