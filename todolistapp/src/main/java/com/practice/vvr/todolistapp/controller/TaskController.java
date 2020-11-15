package com.practice.vvr.todolistapp.controller;

import java.text.ParseException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.vvr.todolistapp.entity.Task;
import com.practice.vvr.todolistapp.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	private static final Logger taskLogger = Logger.getLogger(TaskController.class.getName());
	
	@Autowired
	private TaskService taskService;
//	
//	public TaskController(TaskService taskService) {
//		this.taskService = taskService;
//	}
	
	// To add controller to view all the tasks
	@GetMapping("/list")
	public String getTasks(Model taskModel) {
		
		List<Task> allTasks = taskService.getTasks();
		
		taskModel.addAttribute("tasks", allTasks);
		
		return "listtasks";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model taskModel) {
		
		// Model attribute to bind form data
		Task newTask = new Task();
		
		taskLogger.info("new task object created");
		
		taskModel.addAttribute("newTask", newTask);
		
		return "add-task";
		
	}
	
	@PostMapping("/processTaskForm")
	public String processTaskForm(@ModelAttribute("newTask") Task newTask) throws ParseException {
		
		newTask.setDateTimeAdded();
		
		newTask.setTaskEnabled(1);
		
		newTask.setUserTaskId(1);
		
		taskService.saveTask(newTask);
		
		return "redirect:/task/list";
		
	}

}
