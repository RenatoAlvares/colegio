package com.example.colegio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.colegio.entity.Seccion;
import com.example.colegio.service.SeccionService;

@RestController
@RequestMapping("/seccion")
public class SeccionController {
	@Autowired
	private SeccionService seccionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Seccion>> getSeccions(){
		try {
			List<Seccion> list = new ArrayList<>();
			list = seccionService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
