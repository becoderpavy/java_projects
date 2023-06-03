package com.prog.service;

import java.util.List;

import com.prog.entites.AssignManager;
import com.prog.entites.Emp;
import com.prog.entites.Leave;
import com.prog.entites.ProjectStatus;

public interface ManagerService {

	public List<AssignManager> getAllAssignUserByManager(long managerId);

	public Emp getEmpById(long id);

	public AssignManager updateProject(AssignManager as);

	public AssignManager getByManagerAndUser(long mid, long uid);

	public ProjectStatus createProjectStatus(ProjectStatus p);

	public List<ProjectStatus> getProjectStatus(long managerId, long userId);

	public List<Leave> getAllLeavesByManager(long managerId);

	public Leave updateLeaveStatus(String st,long id);

}
