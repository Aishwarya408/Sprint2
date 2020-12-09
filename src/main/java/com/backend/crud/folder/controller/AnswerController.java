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
import com.backend.crud.folder.model.Answer;
import com.backend.crud.folder.model.Question;
import com.backend.crud.folder.service.AnswerService;

//import com.backend.crud.folder.exceptions.DuplicateRecordException;
//import com.backend.crud.folder.exceptions.RecordNotFoundException;
//import com.backend.crud.folder.model.Question;
//import com.backend.crud.folder.service.QuestionService;



@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/Answer_details/")
public class AnswerController{


	Logger log = LoggerFactory.getLogger(QuestionController.class);
	
	@Autowired
	private AnswerService answerService;

@GetMapping(value = {"/"})
public @ResponseBody List<Answer> getAllAnswer() 
{ 
	
	List<Answer> answer = answerService.getAllAnswers();
	
	return answer;
}
@GetMapping("/{answerid}")
public ResponseEntity<Answer> getAnswerById (@PathVariable int answerid)
{
	if(answerService.getAnswerById(answerid)==null)
	{
		throw new RecordNotFoundException("Record not found with id:"+answerid);
	}
	else
	{
		return new ResponseEntity<Answer>(answerService.getAnswerById(answerid),HttpStatus.OK);
	}
}
@PostMapping("/")
public ResponseEntity<Answer> add(@RequestBody Answer answer)
{
	int id=answerService.addAnswer(answer);
	if(id!=0)
	{
		return new ResponseEntity<Answer>(answerService.getAnswerById(id),HttpStatus.OK);
	}else
	{
		throw new DuplicateRecordException("ID already exists");
	}
}


}
