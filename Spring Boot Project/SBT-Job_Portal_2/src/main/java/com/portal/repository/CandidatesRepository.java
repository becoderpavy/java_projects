package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entites.Candidates;

public interface CandidatesRepository extends JpaRepository<Candidates, Long> {

	public List<Candidates> findByUserIdOrderByIdDesc(long uid);

	public boolean existsByJobIdAndUserId(long jid, long uid);

	public List<Candidates> findByRecruiterIdAndJobIdOrderByIdDesc(long rid,long jid);
	
	public long countByRecruiterIdAndJobId(long rid,long jid);

}
