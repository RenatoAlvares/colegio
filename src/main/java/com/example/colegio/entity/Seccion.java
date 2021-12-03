package com.example.colegio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seccion")
public class Seccion implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -1284312853760166210L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idseccion")
	private int id;
	
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "seccion", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RegistroAlumno> listRegistroAlumnos = new ArrayList<>();
}
