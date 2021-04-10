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
	
	private static final Logger TASKLOGGER = Logger.getLogger(TaskController.class.getName());
	
	@Autowired
	private TaskService taskService;
//	
//	public TaskController(TaskService taskService) {
//		this.taskService = taskService;
//	}
	
	// To add controller to view all the tasks
	@GetMapping("/list")
	public String getTasks(Model taskModel) {
		
		List<Task> allTasks = taskService.findByOrderByDateTimeAdded();
		
		taskModel.addAttribute("tasks", allTasks);
		
		return "listtasks";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model taskModel) {
		
		// Model attribute to bind form data
		Task newTask = new Task();
				
		taskModel.addAttribute("newTask", newTask);
		
		return "add-task";
		
	}
	
	@PostMapping("/processTaskForm")
	public String processTaskForm(@ModelAttribute("newTask") Task newTask) throws ParseException {
		
		newTask.setDateTimeAdded();
		
		newTask.setTaskEnabled(1);
		
		// For temporary purpose
		newTask.setUserTaskId(1);
		
		taskService.saveTask(newTask);
		
		return "redirect:/task/list";
		
	}
	
	@GetMapping("/formForUpdate")
	public String formForUpdate(@ModelAttribute("taskId") int taskId, Model newTask) {
		
		Task tempTask = taskService.findById(taskId);  
		
		newTask.addAttribute("newTask", tempTask);
		
		return "add-task";
		
	}
	
	@GetMapping("/deleteTask")
	public String deleteTask(@ModelAttribute("taskId") int taskId) {
		
		taskService.deleteTask(taskId);
		
		return "redirect:/task/list";
	}

}
