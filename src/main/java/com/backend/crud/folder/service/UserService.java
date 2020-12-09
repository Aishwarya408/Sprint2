package com.backend.crud.folder.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.folder.dao.UserRepository;
import com.backend.crud.folder.exceptions.UserNotFoundException;
import com.backend.crud.folder.model.User;




@Service//class that provides business services.
public class UserService {

	@Autowired
	private UserRepository urRepository;
	

	public User registerUser(User user)
	{
		System.out.println("Topic added.");
		return urRepository.save(user);
	}

	
    public User updateUser(int userId, User user) throws UserNotFoundException
    {

	      Optional<User> repUser = urRepository.findById(userId);

	        if (repUser.isPresent()) {

		    User userToBeUpdated = repUser.get();
		    userToBeUpdated.setPassword(user.getPassword());
		    userToBeUpdated.setFirstName(user.getFirstName());
		    userToBeUpdated.setLastName(user.getLastName());
		    userToBeUpdated.setEmail(user.getEmail());
		    userToBeUpdated.setContactno(user.getContactno());
		   
		    return urRepository.save(userToBeUpdated);
	      }
	      else
	      {
				throw new UserNotFoundException("No User present with the given Id to Update...Please enter valid Id to update");

	      }
      }
    
      
     public int deleteUser(int userId) throws UserNotFoundException
     {
    	 Optional<User> repUser = urRepository.findById(userId);
    		 
    	  if(repUser.isPresent())
    	   {
    	      urRepository.deleteById(userId);
              System.out.println("User details are deleted Successfully");
    		}
    	    else
    		{
    		    throw new UserNotFoundException("Enter valid Id to be deleted");
    		}
		    return userId;
      }
     
    
	 public User findByUserId(int userId) throws UserNotFoundException
	 {
	      Optional<User> repUser = urRepository.findById(userId);
	      
	      if(repUser.isPresent())
	      {
			 return repUser.get();
		  }
	      else
	      {
  		    throw new UserNotFoundException("Enter valid Id to view the User details"); 
	      }
		
	 }
	 
	 
	 public List<User> getAllUsers()
	 {
	 
		System.out.println("Users...");
		return urRepository.findAll();
	 }
}







