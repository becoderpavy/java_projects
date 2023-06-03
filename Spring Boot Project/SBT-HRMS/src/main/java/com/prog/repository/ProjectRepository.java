package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
