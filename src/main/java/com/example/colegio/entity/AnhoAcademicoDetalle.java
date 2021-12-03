package com.example.colegio.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anhoacademicodetalle")
public class AnhoAcademicoDetalle implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -8986363019318779180L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idaadetalle")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idanhoacademico", referencedColumnName = "idanhoacademico")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private AnhoAcademico anhoAcademico;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Asignatura asignatura;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Profesor profesor;
	
}
