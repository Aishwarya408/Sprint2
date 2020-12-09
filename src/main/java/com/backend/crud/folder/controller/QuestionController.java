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
import com.backend.crud.folder.exceptions.RecordNotFoundException;
import com.backend.crud.folder.model.Question;
import com.backend.crud.folder.service.QuestionService;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/Question_details/")
public class QuestionController{

	Logger log = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private QuestionService questionService;

@GetMapping(value = {"/"})
public @ResponseBody List<Question> getAllQuestion() 
{ 
	
	List<Question> question = questionService.getAllQuestions();
	
	return question;
}
@GetMapping("/{questionid}")
public ResponseEntity<Question> getQuestionById (@PathVariable int questionid)
{
	if(questionService.getQuestionById(questionid)==null)
	{
		throw new RecordNotFoundException("Record not found with id:"+questionid);
	}
	else
	{
		return new ResponseEntity<Question>(questionService.getQuestionById(questionid),HttpStatus.OK);
	}
}
@PostMapping("/")
public ResponseEntity<Question> add(@RequestBody Question question)
{
	int questionid=questionService.addQuestion(question);
	if(questionid!=0)
	{
		return new ResponseEntity<Question>(questionService.getQuestionById(questionid),HttpStatus.OK);
	}else
	{
		throw new DuplicateRecordException("ID already exists");
	}
}

@PutMapping("/{questionid}")
public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
{
	if(questionService.updateQuestion(question).getId()==0)
	{
		throw new RecordNotFoundException("Record not found");
	}
	else {
		return new ResponseEntity<Question>(questionService.updateQuestion(question),HttpStatus.OK);
	}
}

@DeleteMapping("/{questionid}")
public ResponseEntity<Question> delete(@PathVariable int questionid)
{
	Question question=questionService.getQuestionById(questionid);
	if(questionService.delete(questionid))
	{
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	else
	{
		System.out.println("No Record is found");
		throw new RecordNotFoundException("Record not found with id:"+questionid);
	}
}

}
