package com.backend.crud.folder.exceptions;


public class DuplicateRecordException  extends RuntimeException
{
	public DuplicateRecordException() {
		super();
	}
	
	public DuplicateRecordException(String msg) {
		super(msg);
	}
	
	public DuplicateRecordException(String msg,Throwable clause) {
		super(msg,clause);
	}
	
	public DuplicateRecordException(Throwable clause) {
		super(clause);
	}
}
