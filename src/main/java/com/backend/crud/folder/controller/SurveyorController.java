package com.backend.crud.folder.controller;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
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
import com.backend.crud.folder.model.Surveyor;
import com.backend.crud.folder.service.SurveyorService;


@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("/Surveyor_details/")
public class SurveyorController{


	Logger log = LoggerFactory.getLogger(SurveyorController.class);
	
	@Autowired
	private SurveyorService surveyorService;
	
@GetMapping("/surveyors")
	public @ResponseBody List<Surveyor> getAllSurveyors()
	{
		List<Surveyor> adminlist=surveyorService.getAllSurveyors();
		return adminlist;
	}

//@GetMapping("getUserDetails/{username}/{password}")
//public ResponseEntity<Surveyor> getUserDetails(@PathVariable String username,@PathVariable String password)
//{
//	if(surveyorService.getUserDetails(username, password)==null)
//	{
//		throw new RecordNotFoundException("Record not found with id: "+ username);
//	}
//	else
//	{
//		return new ResponseEntity<Surveyor>(surveyorService.getUserDetails(username,password),HttpStatus.OK);
//	}
//}


@GetMapping("/{surveyorid}")
public ResponseEntity<Surveyor> getSurveyorById (@PathVariable int surveyorid)
{
	if(surveyorService.getSurveyorById(surveyorid)==null)
	{
		throw new RecordNotFoundException("Record not found with id:"+surveyorid);
	}
	else
	{
		return new ResponseEntity<Surveyor>(surveyorService.getSurveyorById(surveyorid),HttpStatus.OK);
	}
}


@PostMapping("/")
public ResponseEntity<Surveyor> insert(@RequestBody Surveyor surveyor)
{
	System.out.println("Rac");
	int surveyorid=surveyorService.insertSurveyor(surveyor);
	if(surveyorid!=0)
	{
		return new ResponseEntity<Surveyor>(surveyorService.getSurveyorById(surveyorid),HttpStatus.OK);
	}else
	{
		throw new DuplicateRecordException("ID already exists");
	}
}

@PutMapping("/{surveyorid}")
public ResponseEntity<Surveyor> updateSurveyor(@RequestBody Surveyor surveyor)
{
	if(surveyorService.updateSurveyor(surveyor).getId()==0)
	{
		throw new RecordNotFoundException("Record not found");
	}
	else {
		return new ResponseEntity<Surveyor>(surveyorService.updateSurveyor(surveyor),HttpStatus.OK);
	}
}


@DeleteMapping("/{surveyorid}")
public ResponseEntity<Surveyor> delete(@PathVariable int surveyorid)
{
	Surveyor surveyor=surveyorService.getSurveyorById(surveyorid);
	if(surveyorService.deleteSurveyorbyId(surveyorid))
	{
		return new ResponseEntity<Surveyor>(surveyor,HttpStatus.OK);
	}
	else
	{
		System.out.println("No Record is found");
		throw new RecordNotFoundException("Record not found with id:"+surveyorid);
	}
}


}
