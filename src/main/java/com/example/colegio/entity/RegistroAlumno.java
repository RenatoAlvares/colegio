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
@Table(name = "registroalumno")
public class RegistroAlumno  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 2330608067607161647L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idregistroalumno")
	private int id;

	@Column(name = "fecharegistro")
	private Date fechaRegistro;
	
	private String estado;
		
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idalumno", referencedColumnName = "idalumno")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idanhoacademico", referencedColumnName = "idanhoacademico")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private AnhoAcademico anhoAcademico;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idseccion", referencedColumnName = "idseccion")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Seccion seccion;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "registroAlumno", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RecordAcademico> listRecordAcademico = new ArrayList<>();
}
