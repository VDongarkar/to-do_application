package com.learn_spring_web.myFirstWebApplication.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity(name = "TODO")
public class ToDo {
	
	public ToDo() {
		
	}
	
	public ToDo(int id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String username;
	
	
	@Size(min=10, message = "Enter atleast 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", userName=" + username + ", description=" + description + ", TargetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	
}
