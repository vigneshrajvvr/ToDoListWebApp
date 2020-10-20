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
	private int id;
	
	@Column(name="task_title")
	private String title;
	
	@Column(name="task_description")
	private String taskDescription;
	
	@Column(name="date_time_added")
	private String dateTimeAdded;

	public Task(int id, String title, String taskDescription, String dateTimeAdded) {
		super();
		this.id = id;
		this.title = title;
		this.taskDescription = taskDescription;
		this.dateTimeAdded = dateTimeAdded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", taskDescription=" + taskDescription + ", dateTimeAdded="
				+ dateTimeAdded + "]";
	}
	
}
