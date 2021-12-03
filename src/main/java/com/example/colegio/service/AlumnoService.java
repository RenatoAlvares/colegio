package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.Alumno;

public interface AlumnoService {
	Alumno create(Alumno obj);
	Alumno update(Alumno obj);
	void delete(int id);
	Alumno read(int id);
	List<Alumno> readAll();
}
