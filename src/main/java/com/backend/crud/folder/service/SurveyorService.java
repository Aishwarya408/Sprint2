package com.backend.crud.folder.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.folder.dao.SurveyorDao;
import com.backend.crud.folder.model.Surveyor;

//import finalsprint2.mapping.dao.SurveyorDao;
//import finalsprint2.mapping.model.Surveyor;

//import com.cg.spring.surveyapp.dao.SurveyorDao;
//import com.cg.spring.surveyapp.dtos.Surveyor;




@Service
public class SurveyorService {

	@Autowired
	private SurveyorDao surveyorDao;
	
	public Surveyor getSurveyorById(int surveyorid) {
		return surveyorDao.findById(surveyorid).orElse(null);
	}
	
//	public Surveyor getUserDetails(String username, String password) {
//		return surveyorDao.IsUserExists(username,password);
//	}
	
	public int insertSurveyor(Surveyor surveyor){
		if(surveyorDao.existsById(surveyor.getId()))
		{
			return 0;
		}
		else {
			return surveyorDao.save(surveyor).getId();
		}
	}


	public Surveyor updateSurveyor(Surveyor surveyor){
		if(surveyorDao.existsById(surveyor.getId()))
		{
			return surveyorDao.save(surveyor);
		}
		else
		{
			return new Surveyor();
		}
	}

public boolean deleteSurveyorbyId(int surveyorid) {
		
		if(surveyorDao.existsById(surveyorid))
		{
			surveyorDao.deleteById(surveyorid);
			return true;
		}
		else
		{
			return false;
		}
}

	public List<Surveyor> getAllSurveyors() {
		
			List<Surveyor> adminlist=new ArrayList<Surveyor>();
			surveyorDao.findAll().forEach(surveyor->adminlist.add(surveyor));
			return adminlist;
		}

	}

