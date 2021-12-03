package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Grado;
import com.example.colegio.repository.GradoRepository;
import com.example.colegio.service.GradoService;

@Service
public class GradoServiceImpl  implements GradoService{

	@Autowired
	private GradoRepository repository;
	
	@Override
	public Grado create(Grado obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public Grado update(Grado obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Grado read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Grado> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
