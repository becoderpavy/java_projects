package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Helpline;
import com.prog.entites.Leave;
import com.prog.repository.AssignManagerRepository;
import com.prog.repository.EmpRepository;
import com.prog.repository.HelplineRepository;
import com.prog.repository.LeaveRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private AssignManagerRepository assignRepo;

	@Autowired
	private HelplineRepository helpRepo;

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private LeaveRepository leaveRepo;

	public EmpServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AssignManager getProjectDetailsByUser(long userId) {
		return assignRepo.findByUserId(userId);
	}

	@Override
	public AssignManager getDetailsByProjectId(long pid) {
		return assignRepo.findById(pid).get();
	}

	@Override
	public Emp getEmpById(long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public boolean checkAssignManager(long userId) {
		return assignRepo.existsByUserId(userId);
	}

	@Override
	public AssignManager getAssignManagerByUserID(long userId) {
		return assignRepo.findByUserId(userId);
	}

	@Override
	public Leave saveLeave(Leave l) {
		l.setStatus("Pending");
		return leaveRepo.save(l);
	}

	@Override
	public List<Leave> getLeaveByUserId(long userId) {
		return leaveRepo.findByEmpId(userId);
	}

	@Override
	public Helpline addHelpline(Helpline h) {
		h.setStatus("Pending");
		return helpRepo.save(h);
	}

	@Override
	public List<Helpline> getAllHelplineByEmpId(long id) {
		return helpRepo.findByEmpId(id);
	}

	@Override
	public Emp updateProfile(Emp emp) {

		Emp oldEmp = empRepo.findById(emp.getId()).get();

		emp.setPassword(oldEmp.getPassword());
		emp.setRole(oldEmp.getRole());

		return empRepo.save(emp);
	}

}
