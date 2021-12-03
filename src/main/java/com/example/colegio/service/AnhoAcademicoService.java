package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.AnhoAcademico;

public interface AnhoAcademicoService {
	AnhoAcademico create(AnhoAcademico obj);
	AnhoAcademico update(AnhoAcademico obj);
	void delete(int id);
	AnhoAcademico read(int id);
	List<AnhoAcademico> readAll();
}
