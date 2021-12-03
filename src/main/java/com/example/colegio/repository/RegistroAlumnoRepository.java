package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.RegistroAlumno;

@Repository
public interface RegistroAlumnoRepository extends JpaRepository<RegistroAlumno, Integer> {

}
