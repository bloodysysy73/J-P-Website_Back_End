package com.project.service.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Role;
import com.project.repository.RoleRepository;
import com.project.service.ServiceRole;



@Service
public class ServiceImpRole implements ServiceRole{

	@Autowired
	RoleRepository roleRep;
	
	@Override
	public Role ajouter_modifier(Role role) {
		return roleRep.save(role);
	}

	@Override
	public void supprimer_role(Long id) {
		roleRep.deleteById(id);
	}

	@Override
	public List<Role> getAll() {
		return roleRep.findAll();
	}

	@Override
	public Optional<Role> findRole(Long id) {
		return roleRep.findById(id);
	}

	
}
