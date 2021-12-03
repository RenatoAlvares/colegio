package com.example.colegio.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.AnhoAcademico;
import com.example.colegio.repository.AnhoAcademicoRepository;
import com.example.colegio.service.AnhoAcademicoService;

@Service
public class AnhoAcademicoServiceImpl  implements AnhoAcademicoService{

	@Autowired
	private AnhoAcademicoRepository repository;
	
	@Override
	public AnhoAcademico create(AnhoAcademico obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public AnhoAcademico update(AnhoAcademico obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public AnhoAcademico read(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<AnhoAcademico> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
