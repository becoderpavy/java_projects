package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.enties.ComplianceStatus;

public interface ComplianceStatusRepository extends JpaRepository<ComplianceStatus, Long> {

	public List<ComplianceStatus> findByUserId(long userId);

}
