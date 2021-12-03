package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Seccion;
import com.example.colegio.repository.SeccionRepository;
import com.example.colegio.service.SeccionService;

@Service
public class SeccionServiceImpl  implements SeccionService{

	@Autowired
	private SeccionRepository repository;
	
	@Override
	public Seccion create(Seccion obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Seccion update(Seccion obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Seccion read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Seccion> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
