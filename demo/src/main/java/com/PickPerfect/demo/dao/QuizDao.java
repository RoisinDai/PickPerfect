package com.PickPerfect.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PickPerfect.demo.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
