package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Alumno;
import com.example.colegio.repository.AlumnoRepository;
import com.example.colegio.service.AlumnoService;

@Service
public class AlumnoServiceImpl  implements AlumnoService{

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	public Alumno create(Alumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Alumno update(Alumno obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
