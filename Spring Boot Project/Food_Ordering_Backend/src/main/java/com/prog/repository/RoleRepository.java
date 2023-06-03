package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
