package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Publication;
import com.project.model.Utilisateur;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

	@Query("select p from Publication p where p.login = :l")
	List<Publication> findAllByUser(@Param("l") String login);
	
	@Query("select p from Publication p where p.id = :id")
	Publication findByid(@Param("id") int id);
	

}
