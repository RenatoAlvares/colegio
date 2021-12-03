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
@Table(name = "recordacademico")
public class RecordAcademico implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2971617675841335351L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrecordacademico")
	private int id;
	
	private double promedio;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idregistroalumno", referencedColumnName = "idregistroalumno")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RegistroAlumno registroAlumno;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Asignatura asignatura;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "recordAcademico", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RecordAcademicoDetalle> listRecordAcademicoDetalle = new ArrayList<>();
}
