package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer> {

}
