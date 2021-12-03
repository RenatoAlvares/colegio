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
@Table(name = "asignatura")
public class Asignatura  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1547177327315662003L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idasignatura")
	private int id;
	
	private String descripcion;
	
	private String estado;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "asignatura", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AnhoAcademicoDetalle> listAnhoAcademicoDetalle = new ArrayList<>();

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "asignatura", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<RecordAcademico> listRecordAcademico = new ArrayList<>();
}
