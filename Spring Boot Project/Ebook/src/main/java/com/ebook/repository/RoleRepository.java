package com.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebook.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
