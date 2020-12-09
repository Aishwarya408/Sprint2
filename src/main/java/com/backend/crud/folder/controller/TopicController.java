package com.backend.crud.folder.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.crud.folder.exceptions.DuplicateRecordException;
import com.backend.crud.folder.exceptions.TopicNotFoundException;
import com.backend.crud.folder.model.Topic;
import com.backend.crud.folder.service.TopicService;






//connect from postman as http://localhost:5555/participant/
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/topic")
public class TopicController{


	Logger log = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private TopicService topicService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Topic> getAllTopic() 
{ 
	
	List<Topic> topic = topicService.getAllTopics();
	
	return topic;
}

@GetMapping("/{topicid}")
public  ResponseEntity<Topic> getTopicById(@PathVariable int topicid) {
if(topicService.getTopicById(topicid)==null)
{
	throw new TopicNotFoundException("Record not found with id:"+topicid);
}
else
{
	return new ResponseEntity<Topic>(topicService.getTopicById(topicid),HttpStatus.OK);
}
}



@PostMapping("/")
public ResponseEntity<Topic> add(@RequestBody Topic topic)
{
	int topicid=topicService.addTopic(topic);
	if(topicid!=0)
	{
		return new ResponseEntity<Topic>(topicService.getTopicById(topicid),HttpStatus.OK);
	}
	else
	{
		throw new DuplicateRecordException("ID already exists");
	}
}
@PutMapping("/{topicid}")
public  ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) 
{
	if(topicService.updateTopic(topic).getId()==0)
	{
		throw new TopicNotFoundException("Record not found");
	}
	else {
		return new ResponseEntity<Topic>(topicService.updateTopic(topic),HttpStatus.OK);
	}
}

@DeleteMapping("/{topicid}")
public  ResponseEntity<Topic> removeTopic(@PathVariable int topicid) 
{
	Topic topic=topicService.getTopicById(topicid);
	if(topicService.removeTopicbyId(topicid))
	{
		return new ResponseEntity<Topic>(topic,HttpStatus.OK);
	}
	else
	{
		System.out.println("No Record is found");
		throw new TopicNotFoundException("Record not found with id:"+topicid);
	}
}


}