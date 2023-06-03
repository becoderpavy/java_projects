package com.prog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entites.Project;
import com.prog.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	@Override
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public Project getProjectById(long id) {
		return projectRepo.findById(id).get();
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepo.findAll();
	}

	@Override
	public boolean deleteProject(long id) {

		Project p = projectRepo.findById(id).get();
		if (p != null) {
			projectRepo.delete(p);
			return true;
		}
		return false;
	}

	@Override
	public long countProject() {

		return projectRepo.count();
	}

}
