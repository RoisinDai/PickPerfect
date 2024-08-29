package com.PickPerfect.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PickPerfect.demo.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

}
