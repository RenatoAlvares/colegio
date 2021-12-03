package com.example.colegio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.colegio.entity.AnhoAcademico;
import com.example.colegio.service.AnhoAcademicoService;

@RestController
@RequestMapping("/anhoacademico")
public class AnhoAcademicoController {
	
	private String estadoCreate="HABILITADO";
	
	@Autowired
	private AnhoAcademicoService anhoAcademicoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<AnhoAcademico>> getAnhoAcademicos(){
		try {
			List<AnhoAcademico> list = new ArrayList<>();
			list = anhoAcademicoService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<AnhoAcademico> save(@RequestBody AnhoAcademico al){
		try {
			al.setEstado(estadoCreate);
			return new ResponseEntity<>(anhoAcademicoService.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<AnhoAcademico> getUser(@PathVariable("id") int id){
		AnhoAcademico al = anhoAcademicoService.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			anhoAcademicoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<AnhoAcademico> update(@RequestBody AnhoAcademico al, @PathVariable("id") int id){
		try {
			AnhoAcademico a = anhoAcademicoService.read(id);
			if(a.getId()>0) {
				a.setAnho(al.getAnho());
				a.setEstado(al.getEstado());
				a.setGrado(al.getGrado());
				return new ResponseEntity<>(anhoAcademicoService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

