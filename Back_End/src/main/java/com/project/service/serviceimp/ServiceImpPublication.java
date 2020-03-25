package com.project.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Publication;
import com.project.model.Utilisateur;
import com.project.repository.PublicationRepository;
import com.project.service.ServicePublication;
import com.project.service.ServiceUtilisateur;

@Service
public class ServiceImpPublication implements ServicePublication{
	
	@Autowired
	PublicationRepository PublicationRep ;
	
	@Autowired
	ServiceUtilisateur su;

	@Override
	public Publication addOrModify(Publication avis) {

		return PublicationRep.save(avis);
	}

	@Override
	public void deleteById(int id) {

		PublicationRep.deleteById(id);
	}

	@Override
	public List<Publication> getAll() {
		return PublicationRep.findAll();
	}

	@Override
	public List<Publication> getPublicationByUser(String login) {
			return PublicationRep.findAllByUser(login);
	}

	@Override
	public Publication findByid(int id) {
		return PublicationRep.findByid(id) ;
	}

}
