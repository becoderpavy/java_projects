package com.prog.service;

import java.util.List;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Helpline;
import com.prog.entites.Leave;

public interface EmpService {

	public AssignManager getProjectDetailsByUser(long userId);

	public AssignManager getDetailsByProjectId(long pid);

	public Emp getEmpById(long id);

	public boolean checkAssignManager(long userId);

	public AssignManager getAssignManagerByUserID(long userId);

	public Leave saveLeave(Leave l);

	public List<Leave> getLeaveByUserId(long userId);

	public Helpline addHelpline(Helpline h);

	public List<Helpline> getAllHelplineByEmpId(long id);

	public Emp updateProfile(Emp emp);

}
