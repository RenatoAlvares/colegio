package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.AnhoAcademicoDetalle;

@Repository
public interface AnhoAcademicoDetalleRepository extends JpaRepository<AnhoAcademicoDetalle, Integer> {

}
