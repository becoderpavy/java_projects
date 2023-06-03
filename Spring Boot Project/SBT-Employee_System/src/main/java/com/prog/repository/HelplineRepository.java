package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Helpline;

public interface HelplineRepository extends JpaRepository<Helpline, Long> {

	public List<Helpline> findByEmpId(long id);

}
