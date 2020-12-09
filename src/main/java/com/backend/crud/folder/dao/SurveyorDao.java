package com.backend.crud.folder.dao;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Surveyor;




@Repository
public interface SurveyorDao extends JpaRepository <Surveyor,Integer> {
	
	List<Surveyor> findAll();
	void deleteById(int id);
	
	//Surveyor IsUserExists(String userName,String userPassword);
}
