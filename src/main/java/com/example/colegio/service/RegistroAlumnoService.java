package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.RegistroAlumno;

public interface RegistroAlumnoService {
	RegistroAlumno create(RegistroAlumno obj);
	RegistroAlumno update(RegistroAlumno obj);
	void delete(int id);
	RegistroAlumno read(int id);
	List<RegistroAlumno> readAll();
}