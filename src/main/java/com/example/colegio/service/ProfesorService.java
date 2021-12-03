package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.Profesor;

public interface ProfesorService {
	Profesor create(Profesor obj);
	Profesor update(Profesor obj);
	void delete(int id);
	Profesor read(int id);
	List<Profesor> readAll();
}
