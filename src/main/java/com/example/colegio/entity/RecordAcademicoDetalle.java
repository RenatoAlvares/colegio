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
@Table(name = "recordacademicodetalle")
public class RecordAcademicoDetalle implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3118072033144933172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idradetalle")
	private int id;

	private String descripcion;

	private double nota;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "idrecordacademico", referencedColumnName = "idrecordacademico")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RecordAcademico recordAcademico;
	
}
