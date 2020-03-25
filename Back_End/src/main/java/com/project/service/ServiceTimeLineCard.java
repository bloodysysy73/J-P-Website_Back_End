package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.TimeLineCard;
import com.project.model.Utilisateur;



public interface ServiceTimeLineCard {
	
	public TimeLineCard addOrModifyTimeLineCard(TimeLineCard u);
	public void deleteTimeLineCard(TimeLineCard p);
	public List<TimeLineCard> getAllTimeLineCard();
	public Optional<TimeLineCard> findById(int id);
	public void deletebyid(int id);
	public TimeLineCard findByid(int id);





}
