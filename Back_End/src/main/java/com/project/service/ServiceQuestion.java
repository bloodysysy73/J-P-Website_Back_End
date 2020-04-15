package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Question;



public interface ServiceQuestion {
	
	public Question addOrModifyQuestion(Question u);
	public void deleteQuestion(Question p);
	public List<Question> getAllQuestion();
	public Optional<Question> findById(int id);
	public void deletebyid(int id);
	public List<Question> findByNote(int note); 







}
