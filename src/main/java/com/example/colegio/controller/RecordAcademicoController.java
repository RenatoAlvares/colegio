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

import com.example.colegio.entity.RecordAcademico;
import com.example.colegio.service.RecordAcademicoService;

@RestController
@RequestMapping("/recordacademico")
public class RecordAcademicoController {
	
	@Autowired
	private RecordAcademicoService recordAcademicoServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<RecordAcademico>> getRecordAcademicos(){
		try {
			List<RecordAcademico> list = new ArrayList<>();
			list = recordAcademicoServ.readAll();
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
	public ResponseEntity<RecordAcademico> save(@RequestBody RecordAcademico al){
		try {
			return new ResponseEntity<>(recordAcademicoServ.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<RecordAcademico> getUser(@PathVariable("id") int id){
		RecordAcademico al = recordAcademicoServ.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			recordAcademicoServ.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<RecordAcademico> update(@RequestBody RecordAcademico al, @PathVariable("id") int id){
		try {
			RecordAcademico a = recordAcademicoServ.read(id);
			if(a.getId()>0) {
				a.setRegistroAlumno(al.getRegistroAlumno());
				a.setAsignatura(al.getAsignatura());
				a.setPromedio(al.getPromedio());
				return new ResponseEntity<>(recordAcademicoServ.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

