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

import com.example.colegio.entity.Alumno;
import com.example.colegio.service.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	private String estadoCreate="HABILITADO";
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Alumno>> getAlumnos(){
		try {
			List<Alumno> list = new ArrayList<>();
			list = alumnoService.readAll();
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
	public ResponseEntity<Alumno> save(@RequestBody Alumno al){
		try {
			al.setEstado(estadoCreate);
			al.setFechaRegistro(new Date());
			return new ResponseEntity<>(alumnoService.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getUser(@PathVariable("id") int id){
		Alumno al = alumnoService.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			alumnoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Alumno> update(@RequestBody Alumno al, @PathVariable("id") int id){
		try {
			Alumno a = alumnoService.read(id);
			if(a.getId()>0) {
				a.setApellidoMaterno(al.getApellidoMaterno());
				a.setApellidoPaterno(al.getApellidoPaterno());
				a.setDireccion(al.getDireccion());
				a.setDni(al.getDni());
				a.setEmail(al.getEmail());
				a.setFechaNacimiento(al.getFechaNacimiento());
				a.setNombres(al.getNombres());
				a.setSexo(al.getSexo());
				a.setTelefono(al.getTelefono());
				return new ResponseEntity<>(alumnoService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

