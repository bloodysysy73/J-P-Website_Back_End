package com.project.service.serviceimp;


import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.Utilisateur;
import com.project.service.ServiceUtilisateur;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	ServiceUtilisateur utilisateurService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurService.findByLogin(username);
		if (utilisateur == null)
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (int i = 0; i < utilisateur.getRoles().size(); i++) {
			authorities.add(new SimpleGrantedAuthority(utilisateur.getRoles().get(i).getNom()));
		}
		return (UserDetails) new User(utilisateur.getLogin(), utilisateur.getPassword(), authorities);
	}
}