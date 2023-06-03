package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.Candidates;
import com.portal.entity.Jobs;
import com.portal.entity.UserDtls;

public interface CandidateRepository extends JpaRepository<Candidates, Integer> {

	public List<Candidates> findByUser(UserDtls user);

	public List<Candidates> findByRecruiter(UserDtls user);

	public List<Candidates> findByRecruiterAndJob(UserDtls user, Jobs job);

	public boolean existsByUserAndJob(UserDtls user, Jobs job);

}
