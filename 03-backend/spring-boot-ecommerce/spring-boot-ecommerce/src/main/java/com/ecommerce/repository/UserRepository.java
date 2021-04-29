package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entity.User;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
}
