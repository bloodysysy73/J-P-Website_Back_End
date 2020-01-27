package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Role;


public interface ServiceRole {

	public Role ajouter_modifier(Role role);
	public void supprimer_role(Long id);
	public List<Role> getAll();
	public Optional<Role> findRole(Long id);
}
