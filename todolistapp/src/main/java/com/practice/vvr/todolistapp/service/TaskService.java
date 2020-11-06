package com.practice.vvr.todolistapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.vvr.todolistapp.dao.TaskRepository;
import com.practice.vvr.todolistapp.entity.Task;

@Service
public class TaskService {
	
	// To get all the tasks
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getTasks() {
		
		return taskRepository.findAll();
		
	}

}
