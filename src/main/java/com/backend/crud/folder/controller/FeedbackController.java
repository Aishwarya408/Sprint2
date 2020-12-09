package com.backend.crud.folder.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.backend.crud.folder.model.Feedback;
import com.backend.crud.folder.service.FeedbackService;

//import finalsprint2.mapping.model.Feedback;
//import finalsprint2.mapping.service.FeedbackService;

//import com.cg.feedback.spring.swagger.dto.Feedback;
//import com.cg.feedback.spring.swagger.service.FeedbackService;
@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("/feedback/")
class FeedbackController{

	Logger log = LoggerFactory.getLogger(FeedbackController.class);
	
	@Autowired
	private FeedbackService feedbackService;
	


	@GetMapping(value = {"/" })
	public @ResponseBody List<Feedback> getFeedbacks() 
	{ 
	
		List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
		return feedbacks;
	}

	@GetMapping("/{id}")
	public @ResponseBody  Feedback getFeedbackById(@PathVariable int id) 
	{
	
		return feedbackService.getFeedbackById(id);
	}



	@PostMapping("/")
	public @ResponseBody Feedback addFeedback(@RequestBody Feedback feedback) 
	{
		return feedbackService.addFeedback(feedback);
	}
	
	@PutMapping("/{id}")
	public @ResponseBody String updateFeedback(@PathVariable int id,@RequestBody Feedback feedback) 
	{
		
		return feedbackService.updateFeedback(id,feedback);
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody String removeFeedback(@PathVariable int id) 
	{
		return feedbackService.removeFeedback(id);
	}


}