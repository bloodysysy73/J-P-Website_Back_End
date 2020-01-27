package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Message;
import com.project.model.Role;


public interface ServiceMessage {

	public Message addOrModify(Message message);
	public void deleteById(int id);
	public List<Message> getAll();
}
