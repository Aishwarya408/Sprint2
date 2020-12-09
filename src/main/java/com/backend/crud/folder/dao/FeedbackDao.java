package com.backend.crud.folder.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Feedback;

//import finalsprint2.mapping.model.Feedback;

//import com.cg.feedback.spring.swagger.dto.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

	List<Feedback> findAll();

	void deleteById(int id);

}