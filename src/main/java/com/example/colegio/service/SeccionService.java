package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.Seccion;

public interface SeccionService {
	Seccion create(Seccion obj);
	Seccion update(Seccion obj);
	void delete(int id);
	Seccion read(int id);
	List<Seccion> readAll();
}