package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.TimeLineCard;



@Repository
public interface TimeLineCardRepository extends JpaRepository<TimeLineCard, Integer> {

	
	

	


	
}

