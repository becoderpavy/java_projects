package com.emp.service;

import java.util.List;

import com.emp.enties.Compliance;
import com.emp.enties.ComplianceStatus;

public interface ComplianceService {

	public Compliance CreateRL(Compliance c);

	public List<Compliance> getAllRL();

	public Compliance getRLById(long id);

	public ComplianceStatus statusUpdate(ComplianceStatus com);

	public List<ComplianceStatus> getComplianceStatusByUser(long userId);

}
