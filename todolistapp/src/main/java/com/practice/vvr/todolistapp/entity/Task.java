package com.practice.vvr.todolistapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String dateTimeAdded;
	
	@Column(name="task_enabled")
	private int taskEnabled;

	public Task(int taskId, String taskTitle, String taskDescription, String dateTimeAdded) {
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

	public String getTitle() {
		return taskTitle;
	}

	public void setTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getDateTimeAdded() {
		return dateTimeAdded;
	}

	public void setDateTimeAdded(String dateTimeAdded) {
		this.dateTimeAdded = dateTimeAdded;
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
