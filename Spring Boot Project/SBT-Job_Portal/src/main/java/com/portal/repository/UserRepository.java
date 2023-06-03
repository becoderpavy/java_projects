package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portal.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public boolean existsByEmail(String email);

	public List<User> findByRoleOrderByIdDesc(String role);

	public User findByEmail(String email);

	public boolean existsByEmailAndMobNo(String email, String mobNo);

	@Query("select u from User u where u.primarySkill LIKE %:primarySkill%  or u.experience LIKE %:experience%")
	public List<User> searchUser(String primarySkill, String experience);

}
