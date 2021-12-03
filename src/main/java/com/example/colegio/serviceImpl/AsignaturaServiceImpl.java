package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Asignatura;
import com.example.colegio.repository.AsignaturaRepository;
import com.example.colegio.service.AsignaturaService;

@Service
public class AsignaturaServiceImpl  implements AsignaturaService{

	@Autowired
	private AsignaturaRepository repository;
	
	@Override
	public Asignatura create(Asignatura obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Asignatura update(Asignatura obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Asignatura read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Asignatura> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
