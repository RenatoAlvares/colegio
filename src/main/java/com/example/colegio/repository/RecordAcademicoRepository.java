package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.RecordAcademico;

@Repository
public interface RecordAcademicoRepository extends JpaRepository<RecordAcademico, Integer> {

}
