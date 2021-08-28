package com.practice.vvr.todolistapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.vvr.todolistapp.entity.Task;
import com.practice.vvr.todolistapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId();

}
