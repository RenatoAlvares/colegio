package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Profesor;
import com.example.colegio.repository.ProfesorRepository;
import com.example.colegio.service.ProfesorService;

@Service
public class ProfesorServiceImpl  implements ProfesorService{

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public Profesor create(Profesor obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Profesor update(Profesor obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Profesor read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Profesor> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
