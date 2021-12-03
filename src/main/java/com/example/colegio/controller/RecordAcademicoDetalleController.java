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

import com.example.colegio.entity.RecordAcademicoDetalle;
import com.example.colegio.service.RecordAcademicoDetalleService;

@RestController
@RequestMapping("/recordacademicodetalle")
public class RecordAcademicoDetalleController {
	
	@Autowired
	private RecordAcademicoDetalleService raDetalleServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<RecordAcademicoDetalle>> getRecordAcademicoDetalles(){
		try {
			List<RecordAcademicoDetalle> list = new ArrayList<>();
			list = raDetalleServ.readAll();
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
	public ResponseEntity<RecordAcademicoDetalle> save(@RequestBody RecordAcademicoDetalle al){
		try {
			return new ResponseEntity<>(raDetalleServ.create(al), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<RecordAcademicoDetalle> getUser(@PathVariable("id") int id){
		RecordAcademicoDetalle al = raDetalleServ.read(id);
		if(al.getId()>0) {
			return new ResponseEntity<>(al, HttpStatus.OK);
		}else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			raDetalleServ.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<RecordAcademicoDetalle> update(@RequestBody RecordAcademicoDetalle al, @PathVariable("id") int id){
		try {
			RecordAcademicoDetalle a = raDetalleServ.read(id);
			if(a.getId()>0) {
				a.setRecordAcademico(al.getRecordAcademico());
				a.setDescripcion(al.getDescripcion());
				a.setNota(al.getNota());				
				return new ResponseEntity<>(raDetalleServ.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

