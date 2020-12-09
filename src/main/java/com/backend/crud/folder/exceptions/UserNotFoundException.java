package com.backend.crud.folder.exceptions;


public class UserNotFoundException extends RuntimeException
{
	
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException()
	{
		
	}

	public UserNotFoundException(String message)
	{
		super(message);
	}
    
	public UserNotFoundException(String message,Throwable clause) 
	{
		super(message,clause);
	}
	
	public UserNotFoundException(Throwable clause)
	{
		super(clause);
	}
	
}


