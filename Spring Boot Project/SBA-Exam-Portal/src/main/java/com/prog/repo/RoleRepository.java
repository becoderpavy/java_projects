package com.prog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
