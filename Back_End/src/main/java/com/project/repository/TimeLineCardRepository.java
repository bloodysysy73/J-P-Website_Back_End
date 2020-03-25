package com.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.TimeLineCard;
import com.project.model.Utilisateur;



@Repository
public interface TimeLineCardRepository extends JpaRepository<TimeLineCard, Integer> {

	@Query("select t from TimeLineCard t where t.id = :id")
	TimeLineCard findByid(@Param("id") int id);

	
}

