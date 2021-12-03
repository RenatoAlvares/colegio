package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.RecordAcademicoDetalle;
import com.example.colegio.repository.RecordAcademicoDetalleRepository;
import com.example.colegio.service.RecordAcademicoDetalleService;

@Service
public class RecordAcademicoDetalleServiceImpl  implements RecordAcademicoDetalleService{

	@Autowired
	private RecordAcademicoDetalleRepository repository;
	
	@Override
	public RecordAcademicoDetalle create(RecordAcademicoDetalle obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public RecordAcademicoDetalle update(RecordAcademicoDetalle obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public RecordAcademicoDetalle read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<RecordAcademicoDetalle> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
