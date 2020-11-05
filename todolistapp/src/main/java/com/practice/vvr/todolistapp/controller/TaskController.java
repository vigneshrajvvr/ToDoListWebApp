package com.practice.vvr.todolistapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.vvr.todolistapp.entity.Task;
import com.practice.vvr.todolistapp.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
//	
//	public TaskController(TaskService taskService) {
//		this.taskService = taskService;
//	}
	
	@GetMapping("/list")
	public String getTasks(Model taskModel) {
		
		List<Task> allTasks = taskService.getTasks();
		
		if(allTasks == null) {
			System.out.println("No tasks found");
		}
		
		taskModel.addAttribute("tasks", taskModel);
		
		return "listtasks";
		
	}

}
