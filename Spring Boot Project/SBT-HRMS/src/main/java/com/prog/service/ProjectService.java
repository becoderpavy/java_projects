package com.prog.service;

import java.util.List;

import com.prog.entites.Project;

public interface ProjectService {

	public Project createProject(Project project);

	public Project getProjectById(long id);

	public List<Project> getAllProject();

	public boolean deleteProject(long id);
	
	public long countProject();

}
