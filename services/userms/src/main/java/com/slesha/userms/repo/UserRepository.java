package com.slesha.userms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slesha.userms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}