package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.RecordAcademicoDetalle;

@Repository
public interface RecordAcademicoDetalleRepository extends JpaRepository<RecordAcademicoDetalle, Integer> {

}