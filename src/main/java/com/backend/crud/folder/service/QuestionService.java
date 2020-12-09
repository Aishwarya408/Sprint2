package com.backend.crud.folder.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.crud.folder.dao.QuestionDao;
import com.backend.crud.folder.model.Question;

//import finalsprint2.mapping.dao.QuestionDao;
////import com.cg.spring.questionapp.dao.QuestionDao;
////import com.cg.spring.questionapp.dtos.Question;
////import com.cg.spring.questionpp.exceptions.RecordNotFoundException;
//import finalsprint2.mapping.model.Question;



@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public List<Question> getAllQuestions() {
		System.out.println("Questions...");
		
		return questionDao.findAll();
		
	}

	public Question getQuestionById(int questionid) {
		return questionDao.findById(questionid).orElse(null);
	}

	public int addQuestion(Question question){
		if(questionDao.existsById(question.getId()))
		{
			return 0;
		}
		else {
			return questionDao.save(question).getId();
		}
	}

	public Question updateQuestion(Question question){
		if(questionDao.existsById(question.getId()))
		{
			return questionDao.save(question);
		}
		else
		{
			return new Question();
		}
	}
public boolean delete(int id) {
		
		if(questionDao.existsById(id))
		{
			questionDao.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
}


}

