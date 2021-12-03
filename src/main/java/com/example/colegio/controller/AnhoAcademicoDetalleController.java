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

import com.example.colegio.entity.AnhoAcademicoDetalle;
import com.example.colegio.service.AnhoAcademicoDetalleService;

@RestController
@RequestMapping("/anhoacademicodetalle")
public class AnhoAcademicoDetalleController {
	
	@Autowired
	private AnhoAcademicoDetalleService aaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<AnhoAcademicoDetalle>> getAnhoAcademicoDetalles(){
		try {
			List<AnhoAcademicoDetalle> list = new ArrayList<>();
			list = aaService.readAll();
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
	public ResponseEntity<AnhoAcademicoDetalle> save(@RequestBody AnhoAcademicoDetalle al){
		try {
			return new ResponseEntity<>(aaService.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<AnhoAcademicoDetalle> getUser(@PathVariable("id") int id){
		AnhoAcademicoDetalle al = aaService.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			aaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<AnhoAcademicoDetalle> update(@RequestBody AnhoAcademicoDetalle al, @PathVariable("id") int id){
		try {
			AnhoAcademicoDetalle a = aaService.read(id);
			if(a.getId()>0) {
				a.setAnhoAcademico(al.getAnhoAcademico());
				a.setAsignatura(al.getAsignatura());
				a.setProfesor(al.getProfesor());
				return new ResponseEntity<>(aaService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

