package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Payslip;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {

	public List<Payslip> findByEmpId(long id);

}
