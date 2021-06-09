package com.delivary.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivary.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	
}
