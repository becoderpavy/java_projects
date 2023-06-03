package com.railway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.railway.entites.TicketDtls;
import com.railway.entites.UserDtls;

public interface TicketRepo extends JpaRepository<TicketDtls, Integer> {

	public List<TicketDtls> findByUserOrderByIdDesc(UserDtls user);

	public List<TicketDtls> findAllByOrderByIdDesc();
	
}
