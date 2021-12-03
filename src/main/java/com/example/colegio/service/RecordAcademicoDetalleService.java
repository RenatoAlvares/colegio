package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.RecordAcademicoDetalle;

public interface RecordAcademicoDetalleService {
	RecordAcademicoDetalle create(RecordAcademicoDetalle obj);
	RecordAcademicoDetalle update(RecordAcademicoDetalle obj);
	void delete(int id);
	RecordAcademicoDetalle read(int id);
	List<RecordAcademicoDetalle> readAll();
}
