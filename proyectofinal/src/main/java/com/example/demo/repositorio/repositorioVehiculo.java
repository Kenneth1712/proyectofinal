package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.modelo.modeloVehiculos;

public interface repositorioVehiculo extends JpaRepository<modeloVehiculos, Long> {
	   List<modeloVehiculos> findByTipo(String tipo);
}