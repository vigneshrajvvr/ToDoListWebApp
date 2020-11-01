package com.practice.vvr.todolistapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.vvr.todolistapp.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
