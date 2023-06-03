package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entites.LibraryDtls;
import com.library.entites.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	public List<Orders> findByUserId(int id);

	public List<Orders> findByLibrary(LibraryDtls library);

}
