package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Question;
import com.project.repository.QuestionRepository;
import com.project.service.ServiceQuestion;



@Service
public class ServiceImpQuestion implements ServiceQuestion{

	@Autowired
	QuestionRepository QuestionRep;

	@Override
	public Question addOrModifyQuestion(Question a) {
		return QuestionRep.save(a);
	}

	@Override
	public void deleteQuestion(Question p) {
		QuestionRep.delete(p);
	}

	@Override
	public List<Question> getAllQuestion() {
		return QuestionRep.findAll();
	}

	@Override
	public Optional<Question> findById(int id) {
		return QuestionRep.findById(id);
	}

	@Override
	public void deletebyid(int id) {
		QuestionRep.deleteById(id);		
	}

	@Override
	public List<Question> findByNote(int note) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
