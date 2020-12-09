package com.backend.crud.folder.dao;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.crud.folder.model.User;



@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	

	List<User> findAll();
	void deleteById(int userId);
	
}


