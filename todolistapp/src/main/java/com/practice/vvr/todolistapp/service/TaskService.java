package com.practice.vvr.todolistapp.service;

import java.util.List;
import java.util.Optional;

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
	
	// to save or update new task
	public void saveTask(Task newTask) {
		
		taskRepository.save(newTask);
		
	}
	
	public Task findById(int taskId) {
		
		Optional<Task> result = taskRepository.findById(taskId);
		
		Task tempTask = null;
		
		if(result.isPresent()) {
			tempTask = result.get();
		} else {
			
			// If task is not found
			throw new RuntimeException("Task not found "+taskId);
			
		}
		
		return tempTask;
	}
	
	public void deleteTask(int taskId) {
		
		taskRepository.deleteById(taskId);
		
	}

}
