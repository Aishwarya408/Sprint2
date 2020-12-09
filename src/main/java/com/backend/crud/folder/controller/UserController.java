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

import com.backend.crud.folder.exceptions.UserNotFoundException;
import com.backend.crud.folder.model.User;
import com.backend.crud.folder.service.UserService;



@Controller
@RequestMapping("/userdetails")
public class UserController{

	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService urService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<User> getAllUsers() 
{ 
	
	List<User> user = urService.getAllUsers();

	return user;
}

@GetMapping("/{userId}")
public @ResponseBody  User findByUserId(@PathVariable int userId) throws UserNotFoundException 
{
	
	return urService.findByUserId(userId);
}

@PostMapping("/")
public @ResponseBody User registerUser(@RequestBody User user) 
{
	return urService.registerUser(user);
}

@PutMapping("/{userId}")
public @ResponseBody User updateUser(@PathVariable int userId,@RequestBody  User user) throws UserNotFoundException 
{
	
	return urService.updateUser(userId,user);
}



@DeleteMapping("/{userId}")
public @ResponseBody int deleteUser(@PathVariable int userId) throws UserNotFoundException 
{
	return urService.deleteUser(userId);
}


}






