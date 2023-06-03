package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Collage;
import com.prog.entity.Department;
import com.prog.entity.HOD;

public interface HODRepo extends JpaRepository<HOD, Integer> {

	public HOD findByDepartment(Department department);

	public boolean existsByCollageAndHodNameAndDepartment(Collage c, String hn, Department d);

}
