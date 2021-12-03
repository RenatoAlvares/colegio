package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.Grado;

public interface GradoService {

	Grado create(Grado obj);
	Grado update(Grado obj);
	void delete(int id);
	Grado read(int id);
	List<Grado> readAll();
}
