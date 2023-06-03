package com.prog.service;

import java.util.List;

import org.springframework.expression.spel.ast.Assign;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Helpline;
import com.prog.entites.Payslip;

public interface AdminService {

	public boolean checkEmail(String email);

	public Emp addEmp(Emp e);

	public List<Emp> getEmpByRoles(String role);

	public Emp getEmpById(long id);

	public Emp updateEmp(Emp e);

	public boolean deleteEmp(long id);

	public AssignManager assignManager(AssignManager as);

	public AssignManager checkManagerAssign(long uid);

	public List<Helpline> getHelpline();

	public Helpline getHelpLineById(long id);

	public Helpline updateHelpStatus(String st, long id);

	public Payslip uploadPayslip(Payslip pay);

	public List<Emp> getAllEmp();
	
	
	
	

}
