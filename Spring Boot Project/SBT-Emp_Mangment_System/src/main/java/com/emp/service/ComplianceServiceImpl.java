package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.enties.Compliance;
import com.emp.enties.ComplianceStatus;
import com.emp.repository.ComplianceRepository;
import com.emp.repository.ComplianceStatusRepository;

@Service
public class ComplianceServiceImpl implements ComplianceService {

	@Autowired
	private ComplianceRepository comRepo;

	@Autowired
	private ComplianceStatusRepository comStatusRepo;

	@Override
	public Compliance CreateRL(Compliance c) {
		return comRepo.save(c);
	}

	@Override
	public List<Compliance> getAllRL() {
		return comRepo.findAll();
	}

	@Override
	public Compliance getRLById(long id) {
		return comRepo.findById(id).get();
	}

	@Override
	public ComplianceStatus statusUpdate(ComplianceStatus com) {
		return comStatusRepo.save(com);
	}

	@Override
	public List<ComplianceStatus> getComplianceStatusByUser(long userId) {
		return comStatusRepo.findByUserId(userId);
	}

}
