package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.AnhoAcademicoDetalle;
import com.example.colegio.repository.AnhoAcademicoDetalleRepository;
import com.example.colegio.service.AnhoAcademicoDetalleService;

@Service
public class AnhoAcademicoDetalleServiceImpl  implements AnhoAcademicoDetalleService{

	@Autowired
	private AnhoAcademicoDetalleRepository repository;
	
	@Override
	public AnhoAcademicoDetalle create(AnhoAcademicoDetalle obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public AnhoAcademicoDetalle update(AnhoAcademicoDetalle obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public AnhoAcademicoDetalle read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<AnhoAcademicoDetalle> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
