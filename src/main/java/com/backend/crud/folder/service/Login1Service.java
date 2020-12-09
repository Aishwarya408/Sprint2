package com.backend.crud.folder.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.folder.dao.Login1Repository;
import com.backend.crud.folder.exceptions.InvalidOperation;
import com.backend.crud.folder.model.Login1;


@Service
public class Login1Service {
	@Autowired
	private Login1Repository login1Repo;

	public Login1 getLogin1ById(Long id) throws InvalidOperation  {
		   
        try {
        	System.out.println("Login accessed");
            return login1Repo.findById(id).get();
        } catch (InvalidOperation e) {
            System.out.println("Login could not be accessed");
            e.printStackTrace();
            return null;
        }
}


public Login1 addLogin1(Login1 login1) throws InvalidOperation  {
	try {
		System.out.println("Login Added");
		
		return login1Repo.save(login1);
		}
		catch(InvalidOperation e)
		{
		    System.out.println("Login could not be added");
			e.printStackTrace();
		    return null;
		}
}

//public Login1 updateLogin1(Login1 login1) throws InvalidOperation  {
//	System.out.println("Login updated.");
//	try
//      {  
//	Optional<Login1> repLogin1 = loginRepo.findById(id);
//
//	if (repLogin1.isPresent()) {
//
//		Login1 login1ToBeUpdated = repLogin1.get();
//		login1ToBeUpdated.setLoginName(login1.getLoginName());
//		login1ToBeUpdated.setPassword(login1.getPassword());
//		System.out.println("Login1 Updated");
//
//		return login1Repo.save(login1ToBeUpdated);
//
//	}
//   }
//	catch(InvalidOperation e)
//	{
//	    System.out.println("Login could not be updated");
//		e.printStackTrace();
//	    return null;
//	}
//return login1;
//}

//public Login1 updateLogin1(Login1 login1) throws InvalidOperation {
//	try{
//		System.out.println("login updated");
//		return login1Repo.save(login);
//	}
//	catch(InvalidOperation e)
//	{
//		System.out.println("Login cant be updated");
//		e.printStackTrace();
//		return null;
//	}
//	}

public String removeLogin1(Long login1Id) {
	System.out.println("Login removed.");
	login1Repo.deleteById(login1Id);
	return "Login deleted Sucessfully";
}
}