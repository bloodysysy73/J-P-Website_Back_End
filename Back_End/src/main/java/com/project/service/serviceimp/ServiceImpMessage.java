package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Message;
import com.project.model.Role;
import com.project.repository.MessageRepository;
import com.project.repository.RoleRepository;
import com.project.service.ServiceMessage;
import com.project.service.ServiceRole;



@Service
public class ServiceImpMessage implements ServiceMessage{

	@Autowired
	MessageRepository messageRep;

	@Override
	public Message addOrModify(Message message) {
		return messageRep.save(message);
	}

	

	@Override
	public List<Message> getAll() {
		return messageRep.findAll();
	}



	@Override
	public void deleteById(int id) {
		messageRep.deleteById(id);
	}
	

	
}
