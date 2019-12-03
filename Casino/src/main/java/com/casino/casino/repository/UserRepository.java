package com.casino.casino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casino.casino.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
 
}