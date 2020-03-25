package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.TimeLineCard;
import com.project.repository.TimeLineCardRepository;
import com.project.service.ServiceTimeLineCard;



@Service
public class ServiceImpTimeLineCard implements ServiceTimeLineCard{

	@Autowired
	TimeLineCardRepository TimeLineCardRep;

	@Override
	public TimeLineCard addOrModifyTimeLineCard(TimeLineCard a) {
		return TimeLineCardRep.save(a);
	}

	@Override
	public void deleteTimeLineCard(TimeLineCard p) {
		TimeLineCardRep.delete(p);
	}

	@Override
	public List<TimeLineCard> getAllTimeLineCard() {
		return TimeLineCardRep.findAll();
	}

	@Override
	public Optional<TimeLineCard> findById(int id) {
		return TimeLineCardRep.findById(id);
	}

	@Override
	public void deletebyid(int id) {
		TimeLineCardRep.deleteById(id);		
	}

	@Override
	public TimeLineCard findByid(int id) {
		return TimeLineCardRep.findByid(id) ;
	}


	
}
