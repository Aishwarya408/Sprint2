package com.backend.crud.folder.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.crud.folder.dao.AnswerDao;
import com.backend.crud.folder.model.Answer;



@Service
public class AnswerService {

	@Autowired
	private AnswerDao answerDao;

	public List<Answer> getAllAnswers() {
		System.out.println("Answers...");
		
		return answerDao.findAll();
		
	}

	public Answer getAnswerById(int answerid) {
		return answerDao.findById(answerid).orElse(null);
	}

	public int addAnswer(Answer answer){
		if(answerDao.existsById(answer.getId()))
		{
			return 0;
		}
		else {
			return answerDao.save(answer).getId();
		}
	}

	

}

