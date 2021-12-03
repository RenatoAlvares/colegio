package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

}