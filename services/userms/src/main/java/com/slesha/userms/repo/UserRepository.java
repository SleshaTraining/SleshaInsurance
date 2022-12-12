package com.slesha.userms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.slesha.userms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmailIdAndPassword(String emailId,String password);
}