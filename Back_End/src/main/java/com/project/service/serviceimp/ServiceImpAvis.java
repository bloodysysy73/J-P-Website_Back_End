package com.project.service.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Avis;
import com.project.model.Utilisateur;
import com.project.repository.AvisRepository;
import com.project.service.ServiceAvis;
import com.project.service.ServiceUtilisateur;

@Service
public class ServiceImpAvis implements ServiceAvis{
	
	@Autowired
	AvisRepository avisRep ;
	
	@Autowired
	ServiceUtilisateur su;

	@Override
	public Avis addOrModify(Avis avis) {

		return avisRep.save(avis);
	}

	@Override
	public void deleteById(int id) {

		avisRep.deleteById(id);
	}

	@Override
	public List<Avis> getAll() {
		return avisRep.findAll();
	}

	@Override
	public List<Avis> getAvisByUser(String login) {
			return avisRep.findAllByUser(login);
	}

}
