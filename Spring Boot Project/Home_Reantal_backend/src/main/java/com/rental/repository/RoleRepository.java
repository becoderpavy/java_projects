package com.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rental.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
