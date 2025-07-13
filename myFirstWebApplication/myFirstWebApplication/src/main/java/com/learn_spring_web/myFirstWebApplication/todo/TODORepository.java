package com.learn_spring_web.myFirstWebApplication.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TODORepository extends JpaRepository<ToDo, Integer>{

	public List<ToDo> findByUsername(String username);
		
}
