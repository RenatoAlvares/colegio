package com.example.colegio.service;

import java.util.List;

import com.example.colegio.entity.AnhoAcademicoDetalle;

public interface AnhoAcademicoDetalleService {
	AnhoAcademicoDetalle create(AnhoAcademicoDetalle obj);
	AnhoAcademicoDetalle update(AnhoAcademicoDetalle obj);
	void delete(int id);
	AnhoAcademicoDetalle read(int id);
	List<AnhoAcademicoDetalle> readAll();
}