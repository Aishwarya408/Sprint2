package com.backend.crud.folder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Topic;





@Repository
public interface TopicDao  extends JpaRepository <Topic,Integer> {
	
	List<Topic> findAll();
	void deleteById(int id);
	
	

}