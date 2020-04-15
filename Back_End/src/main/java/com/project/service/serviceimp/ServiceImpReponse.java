package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Reponse;
import com.project.repository.ReponseRepository;
import com.project.service.ServiceReponse;



@Service
public class ServiceImpReponse implements ServiceReponse{

	@Autowired
	ReponseRepository ReponseRep;

	@Override
	public Reponse addOrModifyReponse(Reponse a) {
		return ReponseRep.save(a);
	}

	@Override
	public void deleteReponse(Reponse p) {
		ReponseRep.delete(p);
	}

	@Override
	public List<Reponse> getAllReponse() {
		return ReponseRep.findAll();
	}

	@Override
	public Optional<Reponse> findById(int id) {
		return ReponseRep.findById(id);
	}

	@Override
	public void deletebyid(int id) {
		ReponseRep.deleteById(id);		
	}

	
}
