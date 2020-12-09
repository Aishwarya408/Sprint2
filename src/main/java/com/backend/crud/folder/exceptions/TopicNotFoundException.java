package com.backend.crud.folder.exceptions;



public class TopicNotFoundException  extends RuntimeException{
    public TopicNotFoundException(){

    }

    public TopicNotFoundException(String msg){
        super(msg);
    }

}