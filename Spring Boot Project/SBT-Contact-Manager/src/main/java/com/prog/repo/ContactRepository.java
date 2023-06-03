package com.prog.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prog.entites.ContactDtls;

public interface ContactRepository extends JpaRepository<ContactDtls,Integer> {

	@Query("from ContactDtls as c where c.user.id=:uid")
	public Page<ContactDtls> findContactSByUser(@Param("uid") int uid,Pageable pagable);
	
}
