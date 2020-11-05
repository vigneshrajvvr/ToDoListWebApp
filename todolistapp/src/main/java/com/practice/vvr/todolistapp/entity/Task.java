package com.practice.vvr.todolistapp.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Task entity
@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private int taskId;
	
	@Column(name="task_title")
	private String taskTitle;
	
	@Column(name="task_description")
	private String taskDescription;
	
	@Column(name="date_time_added")
	private Date dateTimeAdded;
	
	@Column(name="task_enabled")
	private int taskEnabled;
	
	public Task() {
		// default constructor
	}

	public Task(int taskId, String taskTitle, String taskDescription, Date dateTimeAdded) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.dateTimeAdded = dateTimeAdded;
	}

	public int getId() {
		return taskId;
	}

	public void setId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getDateTimeAdded() {
		return dateTimeAdded;
	}

	public void setDateTimeAdded() throws ParseException {
		
		// to store current date whenever a new task is created
		Date date = new Date();
		
		SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		
		this.dateTimeAdded = ft.parse(ft.format(date));
	}

	public int getTaskEnabled() {
		return taskEnabled;
	}

	public void setTaskEnabled(int taskEnabled) {
		this.taskEnabled = taskEnabled;
	}

	@Override
	public String toString() {
		return "Task [id=" + taskId + ", title=" + taskTitle + ", taskDescription=" + taskDescription + ", dateTimeAdded="
				+ dateTimeAdded + "]";
	}
	
}
