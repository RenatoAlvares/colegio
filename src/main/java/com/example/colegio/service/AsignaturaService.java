package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.Asignatura;

public interface AsignaturaService {
	Asignatura create(Asignatura obj);
	Asignatura update(Asignatura obj);
	void delete(int id);
	Asignatura read(int id);
	List<Asignatura> readAll();
}