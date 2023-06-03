package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Leave;
import com.prog.entites.ProjectStatus;
import com.prog.repository.AssignManagerRepository;
import com.prog.repository.EmpRepository;
import com.prog.repository.LeaveRepository;
import com.prog.repository.ProjectStatusRepository;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private AssignManagerRepository assignRepo;

	@Autowired
	private ProjectStatusRepository projectStatusRepo;

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private LeaveRepository leaveRepo;

	@Override
	public List<AssignManager> getAllAssignUserByManager(long managerId) {
		return assignRepo.findByManagerId(managerId);
	}

	@Override
	public Emp getEmpById(long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public AssignManager updateProject(AssignManager as) {

		AssignManager asn = assignRepo.findByUserIdAndManagerId(as.getUserId(), as.getManagerId());

		if (asn != null) {
			asn.setProjectName(as.getProjectName());
			assignRepo.save(asn);
			return asn;
		}

		return null;
	}

	@Override
	public AssignManager getByManagerAndUser(long mid, long uid) {

		return assignRepo.findByUserIdAndManagerId(uid, mid);
	}

	@Override
	public ProjectStatus createProjectStatus(ProjectStatus p) {
		return projectStatusRepo.save(p);
	}

	@Override
	public List<ProjectStatus> getProjectStatus(long managerId, long userId) {
		return projectStatusRepo.findByManagerIdAndUserIdOrderByIdDesc(managerId, userId);
	}

	@Override
	public List<Leave> getAllLeavesByManager(long managerId) {
		return leaveRepo.findByManagerId(managerId);
	}

	@Override
	public Leave updateLeaveStatus(String st, long id) {
		Leave ol = leaveRepo.findById(id).get();
		if (st.equals("ac")) {
			ol.setStatus("Approved");
		} else {
			ol.setStatus("Rejected");
		}

		return leaveRepo.save(ol);
	}

}
