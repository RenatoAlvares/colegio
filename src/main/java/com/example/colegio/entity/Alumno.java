package com.example.colegio.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "alumno")
public class Alumno implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1347917651703350766L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalumno")
	private int id;
	
	private String nombres;
	
	@Column(name = "apellidopaterno")
	private String apellidoPaterno;	
	
	@Column(name = "apellidomaterno")
	private String apellidoMaterno;
	
	private String dni;
	
	private String sexo;
	
	private String direccion;
	
	private String telefono;
	
	private String email;
	
	@Column(name = "fechanacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "fecharegistro")
	private Date fechaRegistro;
	
	private String estado;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "alumno", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RegistroAlumno> listRegistroAlumnos = new ArrayList<>();
}
