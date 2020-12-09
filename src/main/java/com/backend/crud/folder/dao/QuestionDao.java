package com.backend.crud.folder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Question;

//import finalsprint2.mapping.model.Question;

//import com.cg.spring.questionapp.dtos.Question;



@Repository
public interface QuestionDao  extends JpaRepository <Question,Integer> {
	
	List<Question> findAll();
	void deleteById(int questionid);
	

}
