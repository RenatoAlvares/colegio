package com.example.colegio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Usuario;
import com.example.colegio.repository.GestorUsuarios;

@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	@Autowired
	@Qualifier("gestorUsuario")
	private GestorUsuarios repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario user = repo.findByUsuario(username);
		return new User(user.getUsuario(), "{noop}"+user.getPass()
				,true,true,true,true, buildgrante());
	}
	
	public List<GrantedAuthority> buildgrante(){
		List<GrantedAuthority> auths=new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("ADMINISTRADOR"));
		return auths;
	}

}
