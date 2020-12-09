package com.backend.crud.folder.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.Login1;




@Repository
public interface Login1Repository extends JpaRepository<Login1,Long>{
	

	List<Login1> findAll();
	void deleteById(Long id);

}