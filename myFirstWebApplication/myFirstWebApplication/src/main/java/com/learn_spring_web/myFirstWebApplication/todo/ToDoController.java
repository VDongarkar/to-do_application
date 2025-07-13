package com.learn_spring_web.myFirstWebApplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	
	
	public ToDoController(ToDoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	private ToDoService todoservice;
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggdinUsername(model);
		List<ToDo> todos = todoservice.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listToDos";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggdinUsername(model);
		ToDo todo = new ToDo(0, username,"",LocalDate.now().plusYears(1),false);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method = RequestMethod.POST)
	public String AddNewTodoPage(ModelMap model, @Valid ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggdinUsername(model);
		todoservice.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoservice.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model) {
		ToDo todo = todoservice.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model, @Valid ToDo todo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggdinUsername(model);
		todo.setUserName(username);
		todoservice.updateTodo(todo);
		
		
		return "redirect:list-todos";
	}
	
	private String getLoggdinUsername(ModelMap model) {
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
