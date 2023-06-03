package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Collage;
import com.prog.entity.Department;
import com.prog.entity.Faculity;

public interface FaculityRepo extends JpaRepository<Faculity, Integer> {

	public List<Faculity> findByCollage(Collage c);

	public List<Faculity> findByDepartment(Department d);

}
