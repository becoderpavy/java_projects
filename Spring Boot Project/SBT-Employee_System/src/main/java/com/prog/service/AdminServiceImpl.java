package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Helpline;
import com.prog.entites.Payslip;
import com.prog.repository.AssignManagerRepository;
import com.prog.repository.EmpRepository;
import com.prog.repository.HelplineRepository;
import com.prog.repository.PayslipRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private EmpRepository empRepo;

	@Autowired
	private AssignManagerRepository assignRepo;

	@Autowired
	private BCryptPasswordEncoder passworEncoder;

	@Autowired
	private HelplineRepository helplineRepo;

	@Autowired
	private PayslipRepository payslipRepo;

	@Override
	public Emp addEmp(Emp e) {
		e.setPassword(passworEncoder.encode(e.getPassword()));
		return empRepo.save(e);
	}

	@Override
	public List<Emp> getEmpByRoles(String role) {
		return empRepo.findByRoleOrderByIdDesc(role);
	}

	@Override
	public Emp getEmpById(long id) {
		return empRepo.findById(id).get();
	}

	@Override
	public Emp updateEmp(Emp e) {

		Emp oldEmp = empRepo.findById(e.getId()).get();

		e.setPassword(oldEmp.getPassword());

		return empRepo.save(e);
	}

	@Override
	public boolean deleteEmp(long id) {
		Emp e = empRepo.findById(id).get();
		if (e != null) {
			empRepo.delete(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		return empRepo.existsByEmail(email);
	}

	@Override
	public AssignManager assignManager(AssignManager as) {
		as.setProjectName("NA");
		return assignRepo.save(as);
	}

	@Override
	public AssignManager checkManagerAssign(long uid) {
		return assignRepo.findByUserId(uid);
	}

	@Override
	public List<Helpline> getHelpline() {
		return helplineRepo.findAll();
	}

	@Override
	public Helpline getHelpLineById(long id) {
		return helplineRepo.findById(id).get();
	}

	@Override
	public Helpline updateHelpStatus(String st, long id) {

		Helpline oh = helplineRepo.findById(id).get();
		oh.setStatus(st);
		return helplineRepo.save(oh);
	}

	@Override
	public Payslip uploadPayslip(Payslip pay) {
		return payslipRepo.save(pay);
	}

	@Override
	public List<Emp> getAllEmp() {
		return empRepo.findAll();
	}

}
