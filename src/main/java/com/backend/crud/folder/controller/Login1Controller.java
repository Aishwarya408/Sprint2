package com.backend.crud.folder.controller;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backend.crud.folder.model.Login1;
import com.backend.crud.folder.service.Login1Service;




@Controller
@RequestMapping("/login1/")
public class Login1Controller {
	Logger log = LoggerFactory.getLogger(Login1Controller.class);
		@GetMapping("/hello")
		public String hello() {
			return "Hello!";
		}
		@Autowired
		private Login1Service login1Service;
		


	@GetMapping("/login1/{id}")
	
	public @ResponseBody  Login1 getLogin1ById(@PathVariable Long id) 
	{
		
		return login1Service.getLogin1ById(id);
	}

	@PostMapping("/login1")
	
	public @ResponseBody Login1 addLogin1(@RequestBody Login1 login1) 
	{
		return login1Service.addLogin1(login1);
	}
	
	


	@DeleteMapping("/login1/{id}")
	
	public @ResponseBody  String removeLogin1(@PathVariable Long id) 
	{
		return login1Service.removeLogin1(id);
	}


	}