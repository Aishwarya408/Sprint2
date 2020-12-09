package com.backend.crud.folder.dao;
//package com.backend.crud.folder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Answer;
//import com.backend.crud.folder.model.Question;



@Repository
public interface AnswerDao  extends JpaRepository <Answer,Integer> {
	
	List<Answer> findAll();
	void deleteById(int id);
	

}
