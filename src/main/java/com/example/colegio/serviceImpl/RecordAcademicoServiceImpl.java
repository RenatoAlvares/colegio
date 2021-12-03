package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.RecordAcademico;
import com.example.colegio.repository.RecordAcademicoRepository;
import com.example.colegio.service.RecordAcademicoService;

@Service
public class RecordAcademicoServiceImpl  implements RecordAcademicoService{

	@Autowired
	private RecordAcademicoRepository repository;
	
	@Override
	public RecordAcademico create(RecordAcademico obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public RecordAcademico update(RecordAcademico obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public RecordAcademico read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<RecordAcademico> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
