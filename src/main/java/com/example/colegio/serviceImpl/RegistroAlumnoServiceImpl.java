package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.RegistroAlumno;
import com.example.colegio.repository.RegistroAlumnoRepository;
import com.example.colegio.service.RegistroAlumnoService;

@Service
public class RegistroAlumnoServiceImpl  implements RegistroAlumnoService{

	@Autowired
	private RegistroAlumnoRepository repository;
	
	@Override
	public RegistroAlumno create(RegistroAlumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public RegistroAlumno update(RegistroAlumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public RegistroAlumno read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<RegistroAlumno> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
