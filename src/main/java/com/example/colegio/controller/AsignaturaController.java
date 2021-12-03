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

import com.example.colegio.entity.Asignatura;
import com.example.colegio.service.AsignaturaService;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {
	private String estadoCreate="HABILITADO";
	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Asignatura>> getAsignaturas(){
		try {
			List<Asignatura> list = new ArrayList<>();
			list = asignaturaService.readAll();
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
	public ResponseEntity<Asignatura> save(@RequestBody Asignatura al){
		try {
			al.setEstado(estadoCreate);
			return new ResponseEntity<>(asignaturaService.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Asignatura> getUser(@PathVariable("id") int id){
		Asignatura al = asignaturaService.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			asignaturaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Asignatura> update(@RequestBody Asignatura al, @PathVariable("id") int id){
		try {
			Asignatura a = asignaturaService.read(id);
			if(a.getId()>0) {
				a.setDescripcion(al.getDescripcion());
				return new ResponseEntity<>(asignaturaService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

