package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

	public List<Leave> findByEmpId(long userid);

	public List<Leave> findByManagerId(long mid);

}
