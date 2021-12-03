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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anhoacademico")
public class AnhoAcademico implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -1217943146941235408L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idanhoacademico")
	private int id;
	
	private String anho;
	
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idgrado", referencedColumnName = "idgrado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Grado grado;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "anhoAcademico", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RegistroAlumno> listRegistroAlumnos = new ArrayList<>();

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "anhoAcademico", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AnhoAcademicoDetalle> listAnhoAcademicoDetalle = new ArrayList<>();
	
}
