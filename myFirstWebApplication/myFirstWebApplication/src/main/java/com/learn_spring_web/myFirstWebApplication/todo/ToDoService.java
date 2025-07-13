package com.learn_spring_web.myFirstWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<>();
	private static int todoscount = 0;
	static {
		todos.add(new ToDo(++todoscount,"Varad","Learn Spring 1",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++todoscount,"Varad","Learn React development 1",LocalDate.now().plusYears(2),false));
		todos.add(new ToDo(++todoscount,"Varad","Learn CLoud 1",LocalDate.now().plusYears(3),false));
		todos.add(new ToDo(++todoscount,"Varad","Learn Azure 1",LocalDate.now().plusYears(4),false));
	}
	
	public List<ToDo> findByUsername(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUserName().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description,LocalDate targetDate,boolean done ) {
		ToDo todo = new ToDo(++todoscount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public ToDo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid ToDo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
	}
}
