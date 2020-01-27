package com.vats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vats.model.User;

@Repository
public interface AppUserDetailRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

}
