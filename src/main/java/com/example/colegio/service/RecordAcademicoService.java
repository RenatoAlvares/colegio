package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.RecordAcademico;

public interface RecordAcademicoService {
	RecordAcademico create(RecordAcademico obj);
	RecordAcademico update(RecordAcademico obj);
	void delete(int id);
	RecordAcademico read(int id);
	List<RecordAcademico> readAll();
}
