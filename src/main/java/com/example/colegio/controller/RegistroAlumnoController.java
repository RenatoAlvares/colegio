package com.example.colegio.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.example.colegio.entity.RegistroAlumno;
import com.example.colegio.service.RegistroAlumnoService;

@RestController
@RequestMapping("/registroalumno")
public class RegistroAlumnoController {
	
	private String estadoCreate="HABILITADO";
	
	@Autowired
	private RegistroAlumnoService regAlumnoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<RegistroAlumno>> getRegistroAlumnos(){
		try {
			List<RegistroAlumno> list = new ArrayList<>();
			list = regAlumnoService.readAll();
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
	public ResponseEntity<RegistroAlumno> save(@RequestBody RegistroAlumno al){
		try {
			al.setEstado(estadoCreate);
			al.setFechaRegistro(new Date());
			return new ResponseEntity<>(regAlumnoService.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<RegistroAlumno> getUser(@PathVariable("id") int id){
		RegistroAlumno al = regAlumnoService.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			regAlumnoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<RegistroAlumno> update(@RequestBody RegistroAlumno al, @PathVariable("id") int id){
		try {
			RegistroAlumno a = regAlumnoService.read(id);
			if(a.getId()>0) {
				a.setAlumno(al.getAlumno());
				a.setAnhoAcademico(al.getAnhoAcademico());
				a.setSeccion(al.getSeccion());				
				return new ResponseEntity<>(regAlumnoService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

