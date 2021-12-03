package com.example.colegio.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.Usuario;

@Repository("gestorUsuario")
public interface GestorUsuarios extends JpaRepository<Usuario, Serializable>{

	public abstract Usuario findByUsuario(String usuario);
	
}
